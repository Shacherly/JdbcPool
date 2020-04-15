package test;

import test.oom.TestInnerClass;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Test8 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String a = new String("adasdad");
        change(a);
        System.out.println(a);
    }

    static void change(String a) throws NoSuchFieldException, IllegalAccessException {
        Class<? extends String> aClass = a.getClass();
        Field value = aClass.getDeclaredField("value");
        value.setAccessible(true);

        char[] o = (char[]) value.get(a);
        Arrays.fill(o, 'T');

    }

    String a = new TestInnerClass.A().A;
    String b = TestInnerClass.B.B;

}
