package test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestHash {
    HashMap map = new HashMap();
    static final int MAXIMUM_CAPACITY = 1 << 30;

    private static int calculate(int radix, int[] a) {
        int sum = 0;
        for (int value : a) {
            sum = sum * radix + value;
        }
        return sum;
    }

    static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public static void main(String[] args) throws IllegalAccessException {
        // System.out.println("工具：" + calculate(31, new int[]{0, 8, 4,9}));
        // String key1 = "adafqweasq3wrefsdv";
        // int key2 = 61440;
        // int hash = hash(key1);
        // System.out.println(Integer.toBinaryString(Integer.hashCode(key2)));
        // System.out.println(Integer.toBinaryString(hash));
        // System.out.println(Float.hashCode(123.123f));

        /*System.out.println("========");
        System.out.println("1232133".hashCode());
        System.out.println("1232133".hashCode() & 16);*/
        test();
    }

    public static void test() throws IllegalAccessException {
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < 13; i++) {
            map.put(i + 1, i + 1);
        }
        Class<? extends Map> aClass = map.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            if ("table".equals(declaredField.getName())) {
                Object[] o = (Object[]) declaredField.get(map);
                System.out.println("桶长度： " + o.length);
                System.out.println(Arrays.toString(o));
            }
            // 阈值，The next size value at which to resize (capacity * load factor).
            // 官方的解释：0.75倍的capacity，但是结果计算是等于capacity的？可能是早期版本的注释？？？
            if ("threshold".equals(declaredField.getName())) {
                System.out.println("阈值： " + declaredField.get(map));
            }
            if ("size".equals(declaredField.getName())) {
                System.out.println("实际元素个数： " + declaredField.get(map));
            }
        }
    }


    // tableSizeFor是为了计算threshold的
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;// 无符号右移  *0.5
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        // 一般n不可能小于0，也很少能大于MAXIMUM_CAPACITY的，所以n就等于n+1 = cap
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
