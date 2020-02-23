### Jdbc连接池+ORM框架封装

###### 1、最底层的增删改查方法封装于SqlSessionFactory类中

```java
public int insert(String sql, Object... values){
    Connection connection = ConnectionPool.getConnection();
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    // 将sql和？信息拼接完整
    for (int i = 0; i < values.length; i++) {
        // 设置问号的索引位置对应的values值。
        // setObject()则可以对应数据库字段的任何类型。
        preparedStatement.setObject(i + 1, values[i]);
    }
    int affetcedRows = preparedStatement.executeUpdate();
    preparedStatement.close();
    connection.close();
    return affectedRows;
}
// SqlSessionFactory中的方法是传递可变长度数组，Dao中传递对象，再解析对象。
```

###### 2、上面的方法已经很通用了，因此Dao中是不用再写这些片段的，只需要给它准备两个条件

Sql语句和？占位符对应的值。

然后将Sql交给SqlSessionFactory就完事了。

但是再想一下，Sql一定要写在Dao的方法中吗，写在文件中读取不行吗，写在注解里不行吗？

每次都找SqlSessionFactory那干脆直接找他做代理不就好了？

因此Dao变为接口，抽象方法上的注解提供Sql，方法的入参提供？值。每次使用找代理对象做就好了。

###### 3、修改和删除在数据库底层做的事是把缓存中的数据全都写在文件中了，但新增不需要全改变，新增只需要加一行，原来的值没动。

要知道修改和删除底层是来操作文件的，他不可能只改某一行，因此先把缓存改了，再把缓存的结果刷新到文件中。

幻读指的是新增时候出现的问题，不可重复度指的是修改删除出现的问题

###### 4、SqlSessionFactory写了底层的JDBC代码，

