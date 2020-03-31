package test.gc;

public class Test2 {
    public static void main(String[] args) {
        if (true) {
            byte[] placeHolder = new byte[64 * 1024 * 1024];
            System.out.println(placeHolder.length / 1024);
            // placeHolder = null;
        }
        // int p= 1;
        System.gc();
    }
}
