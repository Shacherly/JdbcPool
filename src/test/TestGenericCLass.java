package test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestGenericCLass {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(ArrayList.class.getInterfaces()));

        System.out.println(Arrays.toString(ArrayList.class.getGenericInterfaces()));
        // Type
        System.out.println(ArrayList.class.getGenericSuperclass());

        System.out.println(ArrayList.class.getDeclaringClass());

        System.out.println(Arrays.toString(ArrayList.class.getDeclaredClasses()));

        System.out.println(Integer.class.toGenericString());
    }
}
