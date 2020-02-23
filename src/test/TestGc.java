package test;

public class TestGc {
    public static void main(String[] args) {
        if (true) {
            byte[] place = new byte[64 * 1024 * 1024];
            System.out.println(place.length / 1024);

        }

        System.gc();
    }
}
