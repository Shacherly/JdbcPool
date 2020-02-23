package com.jdbc.util;

public class DateUtil {
    private DateUtil() {

    }

    public static int getNow() {
        long timestamp = System.currentTimeMillis();
        return (int) (timestamp / 1000);
    }
}
