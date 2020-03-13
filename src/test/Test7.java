package test;

public class Test7 {
    public static void main(String[] args) {
        String s1 = "sa";
        String s2 = "sa";
        String s3 = "sasa";
        String s4 = s1 + s2;
        String s = s1 + "124";
        System.out.println(s3 == s4);

        final String s5 = "aa";
        final String s6 = "bb";
        String s7 = "aabb";
        String s8 = s5 + s6;
        System.out.println(s7 == s8);


    }
}
