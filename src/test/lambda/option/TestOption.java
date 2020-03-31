package test.lambda.option;

import com.duing.domain.Admin;

import java.util.*;

public class TestOption {
    public static void main(String[] args) {
        Admin a1 = new Admin(1, "a1");
        Admin a2 = new Admin(2, "a2");
        Admin a3 = new Admin(3, "a3");
        List<Admin> list = new ArrayList<>(Arrays.asList(a1, a2, a3));

        Optional<Admin> max = list.stream().max(Comparator.comparing(Admin::getId));
        Optional<Admin> min = list.stream().min(Comparator.comparing(Admin::getId));

        max.ifPresent(System.out::println);
        min.ifPresent(System.out::println);

        Admin admin = new Admin(4, "tttt");
        Optional<Admin> opt = Optional.ofNullable(admin);
        // opt.ifPresent(System.out::println);
        // System.out.println(opt.orElse(new Admin()));
        System.out.println(
                opt.map(Admin::getAccount)
                        .map(acc -> {
                            String s = acc.toUpperCase();
                            return s.replace("t", "a");
                        }).orElseGet(() -> new Admin(5, "test").getAccount().toUpperCase())
        );
    }
}
