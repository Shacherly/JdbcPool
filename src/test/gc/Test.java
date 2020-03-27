package test.gc;

import test.Test1;

public class Test {
    public static void main(String[] args) {
        // Test1 t1 = new Test1();
        // t1 = null;
        // System.gc();
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        System.out.println(maxMemory / 1024 / 1024);
        System.out.println(totalMemory / 1024 / 1024);
        System.out.println(freeMemory / 1024 / 1024);
    }
}
