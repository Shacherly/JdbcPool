package test;

public class Test2 {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        process(a, b);
        System.out.println(a + b);
        System.out.println(0x00000001);
    }

    public static void process(String a, String b) {
        a = "1";
        b = "2";
    }
}
