package test;

public class TestStringHash {
    public static void main(String[] args) {
        do1();

    }


    static void do1() {
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            String str = "" + i;
            str.hashCode();
        }
        long end = System.currentTimeMillis();
        System.out.println((end - begin));
    }

    static void do2() {//29859
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            String str = new String(String.valueOf(i));
            str.hashCode();
        }
        long end = System.currentTimeMillis();
        System.out.println((end - begin));
    }
}
