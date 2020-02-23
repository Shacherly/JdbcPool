package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test6 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(ArrayList.class.getInterfaces()));

        System.out.println(Arrays.toString(ArrayList.class.getGenericInterfaces()));

        System.out.println(ArrayList.class.getGenericSuperclass());

        System.out.println(Arrays.toString(ArrayList.class.getDeclaredClasses()));
    }
}
