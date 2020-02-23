package test;

import com.duing.domain.Admin;

public class Test5 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Admin admin = new Admin("111");
        test(admin);
        System.out.println(admin);
    }

    private static void test(Admin admin) {
        admin.setAccount("test");
    }
}
