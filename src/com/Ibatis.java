package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ibatis {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/book_store";
        String user = "root";
        String pass = "123456";
        long begin = System.currentTimeMillis();
        Connection connection = DriverManager.getConnection(url, user, pass);
        long end = System.currentTimeMillis();
        System.out.println(end - begin + "ms");
        String sql = "select * from admin";
        PreparedStatement pstat = connection.prepareStatement(sql);

        ResultSet resultSet = pstat.executeQuery();
        while (resultSet.next()) {
            int aid = resultSet.getInt(1);
            String aname = resultSet.getString(2);
            String apwd = resultSet.getString(3);
            System.out.print(aid + "," + aname + "," + apwd);
        }
        resultSet.close();
        pstat.close();
        connection.close();
    }
}
