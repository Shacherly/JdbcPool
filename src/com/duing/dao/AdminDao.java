package com.duing.dao;

import com.duing.domain.Admin;
import com.jdbc.annotation.Param;
import com.jdbc.annotation.SQL;
import com.jdbc.sqlsession.SqlExecutorEnum;
import com.jdbc.sqlsession.SqlSessionFactory;

import java.sql.SQLException;

public interface AdminDao {

    SqlSessionFactory sessionFactory = SqlSessionFactory.getInstance();

    // 持久层---数据的持久化
    // 负责数据的读写，代码都是纯粹的JDBC+SQL

    @SQL(sql = "update admin set password = ? where id = ?", type = SqlExecutorEnum.UPDATE)
    int update(Admin admin) throws SQLException;
    // String sql = "update admin set password = ? where id = ?";

    // update方法不用我们去写原生的代码了，只需要调用现成的SqlSessionFactory中的方法
    // return sessionFactory.update(sql, admin.getPassword(), admin.getId());

    @SQL(sql = "select * from admin where id = ?",
            type = SqlExecutorEnum.SELECT, resultType = Admin.class)
    Admin selectOne(@Param("id") int id) throws SQLException;


    @SQL(type = SqlExecutorEnum.INSERT)
    long insert(Admin admin) throws SQLException;

    // default int update(Admin admin) throws SQLException {
    //     String sql = "update admin set account = ?, password = ? where id = ?";
        // 获取连接
        // Connection connection = ConnectionPool.getConnection();
        // // 预编译，创建状态参数
        // PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // // 将sql和？拼接完整
        // preparedStatement.setString(1, admin.getAccount());
        // preparedStatement.setInt(2, admin.getPassword());
        //
        // // 一般用executeUpdate执行增删改、用executeQuery执行查。
        // int affectedRows = preparedStatement.executeUpdate();
        // preparedStatement.close();
        // connection.close();
        // return affectedRows;但是

        // 以上是原始写法，但是SqlSessionFactory中是有这些代码的，因此不必重复。
        // return sessionFactory.update(sql, admin.getAccount(), admin.getPassword(), admin.getId());

        // 这样一来整个Dao只需要两行代码。
        // 其他CRUD方法一样的只需要两行。
    // }

}
