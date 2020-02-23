package test;

import com.duing.domain.Admin;
import com.duing.domain.TestDomain;

import java.lang.reflect.Field;

public class Test3 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<Admin> adminClass = Admin.class;
        Admin admin = adminClass.newInstance();
        Field[] declaredFields = adminClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            if (declaredField.getType() == TestDomain.class) {
                declaredField.set(admin, TestDomain.class.newInstance());
            }
        }
        System.out.println(admin);
    }

    public static <T> T createObject(Class<T> tClass) throws IllegalAccessException, InstantiationException {
        Field[] declaredFields = tClass.getDeclaredFields();
        return tClass.newInstance();
    }
}
