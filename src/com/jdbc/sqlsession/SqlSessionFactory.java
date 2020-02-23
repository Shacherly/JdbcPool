package com.jdbc.sqlsession;

import com.duing.domain.TestDomain;
import com.jdbc.util.ConnectionPool;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("all")
public class SqlSessionFactory {

    private static volatile SqlSessionFactory sessionFactory;

    private SqlSessionFactory() {

    }

    // 真正的单例模式
    public static SqlSessionFactory getInstance() {
        if (sessionFactory == null) {
            synchronized (SqlSessionFactory.class) {
                if (sessionFactory == null) {
                    sessionFactory = new SqlSessionFactory();
                }
            }
        }
        return sessionFactory;
    }


    // 为了帮所有DAO处理冗余的JDBC操作
    // 设计一个方法，可以处理任何表格任何一条数据的CRUD
    // update和delete在数据库底层做的事情是一样的，都是会话缓存的数据写入数据库文件中了，
    // 把整个数据库文件都改了一遍，原来的文件不要了
    // 但是新增不用大幅改变数据库文件，只需要加一行就行了,文件中原来的值没动

    // 幻读出现的insert的时候
    // 不可重复读出现在delete或者update的时候

    /**
     * 增
     * @param sql
     * @param values
     * @return 新增的记录主键ID，Long型的
     * @throws SQLException
     */
    public long insert(String sql, Object[] values) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        // 注意这里如果没有去适配器中实现对应的方法会出现空指针
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        // 将sql和？信息拼接完整
        for (int i = 0; i < values.length; i++) {
            // 设置问号的索引位置对应的values值。
            preparedStatement.setObject(i + 1, values[i]);
        }
        preparedStatement.executeUpdate();

        // 存储临时新增的数据
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            return generatedKeys.getLong(1);
        }
        return -1;
    }

    /**
     * 删、改
     * @param sql
     * @param values
     * @return
     * @throws SQLException
     */
    // 方法只需要传递sql语句和“问号”占位符对应的一组参数数组即可
    public int update(String sql, Object[] values) throws SQLException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // 将sql和？信息拼接完整
        for (int i = 0; i < values.length; i++) {
            preparedStatement.setObject(i + 1, values[i]);
        }
        int affectedRows = preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
        return affectedRows;
    }

    /**
     * 查
     * @param sql
     * @param values
     * @param resultType
     * @param <T>
     * @return
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public <T> T selectOne(String sql, Object[] values, Class<T> resultType) throws SQLException, InstantiationException, IllegalAccessException {
        Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // 将sql和？信息拼接完整
        for (int i = 0; i < values.length; i++) {
            preparedStatement.setObject(i + 1, values[i]);
        }
        ResultSet resultSet = preparedStatement.executeQuery();// 将结果集信息取出来
        T obj = null;
        if (resultSet.next()) {
            obj = constructByResultSet(resultSet, resultType);
        }
        return obj;
    }

    // 构建对象（其中有充填属性值的过程）
    private <T> T constructByResultSet(ResultSet resultSet, Class<T> resultTypeClass) throws InstantiationException, IllegalAccessException, SQLException {
        T t = constructByResultType(resultTypeClass);
        for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
            String columnName = resultSet.getMetaData().getColumnName(i);
            setFieldValue(t, columnName, resultSet);
        }
        return t;
    }

    // 填充类对象的属性值
    private void setFieldValue(Object obj, String columnName, ResultSet resultSet) throws SQLException, IllegalAccessException {
        String fieldName = formatAsField(columnName);
        if (obj == null) {
            obj = resultSet.getObject(columnName);
            return;
        }
        // 寻找所有类字段
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            // 基本类型或者包装类
            if (genericType(declaredField.getType())) {
                if (declaredField.getName().equals(fieldName)) {
                    // 获取字段的类型String Integer Long Date等等
                    Class<?> fieldType = declaredField.getType();
                    // 通过反射为字段设置该字段的值
                    declaredField.set(obj, resultSet.getObject(columnName, fieldType));
                }
            } else {
                setFieldValue(declaredField.get(obj), columnName, resultSet);
            }
        }
    }

    // 下划线转驼峰  student_name_area 转化为 studentNameArea
    private String formatAsField(String columnName) {
        columnName = columnName.toLowerCase();

        // 生成匹配格式
        Pattern pattern = Pattern.compile("_(\\w)");
        Matcher matcher = pattern.matcher(columnName);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            // matcher.group(1)该格式匹配到之后从找到索引为1的变大写，0号索引是下划线
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        // 把最后一次匹配到内容   之后的字符串  追加到 StringBuffer 中
        matcher.appendTail(sb);
        return sb.toString();
    }

    // 驼峰转下划线 studentNameArea  --->>>   STUDENT_NAME_AREA
    private String formatAsColumn(String fieldName) {
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(fieldName);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            // 找到第一个大写的替换为前面加下划线
            matcher.appendReplacement(sb, "_" + matcher.group(0));
        }
        matcher.appendTail(sb);
        return sb.toString().toUpperCase();
    }

    // insert时根据对象自动拼串
    public long insert(Object[] args) throws IllegalAccessException, SQLException {
        Class<?> aClass = args[0].getClass();
        StringBuilder sql = new StringBuilder("INSERT INTO " + aClass.getSimpleName().toUpperCase() + " (");
        Field[] declaredFields = aClass.getDeclaredFields();
        // 使用LinkedHashSet保证迭代顺序
        Set<Field> fieldSet = new LinkedHashSet<>();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            // Type genericType = declaredField.getGenericType();
            if (declaredField.get(args[0]) != null && declaredField.getModifiers() == Modifier.PRIVATE) {
                fieldSet.add(declaredField);
            }
        }
        Iterator<Field> iterator1 = fieldSet.iterator();
        do {
            sql.append(formatAsColumn(iterator1.next().getName()));
            if (iterator1.hasNext()) {
                sql.append(", ");
            }
        } while (iterator1.hasNext());
        sql.append(") VALUES(");
        Set<Object> fieldValueSet = new HashSet<>();
        Iterator<Field> iterator2 = fieldSet.iterator();
        do {
            fieldValueSet.add(iterator2.next().get(args[0]));
            sql.append("?");
            if (iterator2.hasNext()) {
                sql.append(", ");
            }
        } while (iterator2.hasNext());
        sql.append(")");

        return insert(sql.toString(), fieldValueSet.toArray());
    }

    /**
     * 根据select方法的返回值集合类型创建对应的集合
     * @param returnTypeClass
     * @param <E>
     * @return
     * @throws Exception
     */
    private <E> Collection<E> collecton(Class<E> returnTypeClass) throws Exception {
        if (returnTypeClass == List.class) {
            return new ArrayList<>();
        }
        if (returnTypeClass == Set.class) {
            return new HashSet<>();
        }
        if (returnTypeClass == Collection.class) {
            return new ArrayList<>();
        }
        throw new Exception("不支持的集合类型:" + returnTypeClass.getName());
    }



    /**
     * 根据注解中的ResultType构建对象，如果属性不是基本类型则递归
     * @param resultTypeClass
     * @param <T>
     * @return
     */
    private <T> T constructByResultType(Class<T> resultTypeClass) throws IllegalAccessException, InstantiationException {
        /*
        如果是基本类型则不需要构建对象，直接返回null从ResultSet中取值,
        就是当select的是String就不用下面的递归构建对象了
         */
        if (genericType(resultTypeClass)) {
            return null;
        }
        T t = resultTypeClass.newInstance();// 这样new出来的对象字段全部为null
        Field[] declaredFields = resultTypeClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if (!genericType(declaredField.getType())) {
                declaredField.setAccessible(true);
                // 为对象t赋予该字段的值，只是赋予一个引用。
                declaredField.set(t, constructByResultType(declaredField.getType()));
            }
        }
        return t;
    }

    private boolean genericType(Class<?> fieldTypeClass) {
        return isWrapper(fieldTypeClass) || isPrimitive(fieldTypeClass)
                || fieldTypeClass == Date.class || fieldTypeClass == String.class;
    }

    /**
     * 判断字段类型是否为包装类型
     * @param fieldTypeClass
     * @return
     */
    private boolean isWrapper(Class<?> fieldTypeClass) {
        try {
            return ((Class<?>) fieldTypeClass.getField("TYPE").get(null)).isPrimitive();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 判断字段类型是否为基本类型
     * @param fieldTypeClass
     * @return
     */
    private boolean isPrimitive(Class<?> fieldTypeClass) {
        return fieldTypeClass.isPrimitive();
    }

}
