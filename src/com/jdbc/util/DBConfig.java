package com.jdbc.util;

import java.io.*;
import java.util.Properties;

/**
 * 用于读取配置文件
 */
public class DBConfig {
    // 设为静态  只加载一次
    private static Properties dbConfig;

    static {

        // jdk7的自动关闭流
        try {
            InputStream inputStream = Thread.currentThread()
                    .getContextClassLoader().getResourceAsStream("dbconfig.properties");
            dbConfig = new Properties();
            // 通过当前线程去加载一个文件，但是获得的是字节流，如果有中文可能会导致乱码，还可以加一层字符流
            // InputStream inputStream = new FileInputStream("C://dbconfig.properties");
            // dbConfig.load(new FileReader("src/dbconfig.properties"));
            // dbConfig.load(new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/dbconfig.properties")))));
            // dbConfig.load(new BufferedReader(new FileReader("src/dbconfig.properties")));
            dbConfig.load(new FileInputStream("src/dbconfig.properties"));
            // dbConfig.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getConfig(String key) {
        return dbConfig.getProperty(key, "");
    }

    public static String getConfig(String key, String defaultValue) {
        return dbConfig.getProperty(key, defaultValue);
    }

    public static Integer getIntegerValue(String key) {
        return Integer.parseInt(dbConfig.getProperty(key, ""));
    }

    public static Integer getIntegerValue(String key, String defaultValue) {
        return Integer.parseInt(dbConfig.getProperty(key, defaultValue));
    }
}
