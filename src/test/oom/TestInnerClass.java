package test.oom;

public class TestInnerClass {
    protected static String pro = "a";
    protected final static class A {
        String A = "A";
    }

    static class B {
        static String B = "B";
    }

    abstract static class C {
        static String C = "C";
    }
}

interface OuterClass {}
