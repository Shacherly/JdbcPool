package test;

public class TestHashMap {
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

    public static void main(String[] args) {
        System.out.println("工具：" + calculate(31, new int[]{0, 8, 4,9}));
        String key1 = "adafqweasq3wrefsdv";
        int key2 = 61440;
        int hash = hash(key1);
        System.out.println(Integer.toBinaryString(Integer.hashCode(key2)));
        System.out.println(Integer.toBinaryString(hash));
        // System.out.println(Float.hashCode(123.123f));

        /*System.out.println("========");
        System.out.println("1232133".hashCode());
        System.out.println("1232133".hashCode() & 16);*/
    }
}
