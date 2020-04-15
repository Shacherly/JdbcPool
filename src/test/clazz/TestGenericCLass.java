package test.clazz;

import com.duing.domain.Admin;
import com.duing.domain.User;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestGenericCLass {
    public static void main(String[] args) {
        // System.out.println(Arrays.toString(ArrayList.class.getInterfaces()));
        //
        // System.out.println(Arrays.toString(ArrayList.class.getGenericInterfaces()));
        // // Type
        // System.out.println(ArrayList.class.getGenericSuperclass());
        //
        // System.out.println(ArrayList.class.getDeclaringClass());
        //
        // System.out.println(Arrays.toString(ArrayList.class.getDeclaredClasses()));
        //
        // System.out.println(Integer.class.toGenericString());
        // Admin admin = new Admin("account", 123213);
        // User u1 = new User();
        // System.out.println(u1);
        User user = new User(1, 1L, "小黄", new ArrayList<>());
        Field[] declaredFields = user.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            System.out.println(declaredField.getType());
            System.out.println(declaredField.getGenericType());
            System.out.println(declaredField.getType().getSuperclass());
            System.out.println(declaredField.getType().getGenericSuperclass());
            System.out.println();
        }
    }
}
