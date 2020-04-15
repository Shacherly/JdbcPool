package test.abstrac;

import java.io.Closeable;
import java.io.InputStream;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class TestAbstract extends Test {
    public static void main(String[] args) {
        AbstractMap<Integer, Integer> map = new HashMap<>();
        boolean b = map.containsKey(1);
        System.out.println(map);
        System.out.println();
        System.out.println(get());
        a = 1;
        System.out.println(a);
        // ConcurrentHashMap
        new TestAbstract();
    }


}
 class Test {

    private static final int s;
    static {
        s = 1;
    }

    public Test() {
        System.out.println("abstract Test loaded");
    }

    static int a = 0;

    static int get() {
        return 1;
    }

    public static void main(String[] args) {
        System.out.println("abstract main");
    }
}

