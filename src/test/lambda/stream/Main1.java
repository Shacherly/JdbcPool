package test.lambda.stream;

import com.duing.domain.Admin;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main1 {
    public static void main(String[] args) {
        Admin a1 = new Admin(1, "a1");
        Admin a2 = new Admin(2, "a2");
        Admin a3 = new Admin(3, "a3");
        List<Admin> list = Stream.of(a1, a2, a3).collect(Collectors.toList());
        List<Admin> list1 = Arrays.asList(a1, a2, a3);
        // Set<Admin> collect1 = Stream.of(a1, a2, a3).collect(Collectors.toSet());


        // List<String> strList = Stream.of("a", "b", "c", "d").collect(Collectors.toList());
        // System.out.println();
        // String a = "adasds";
        // String join = String.join(", ", strList);
        String.join(",", "a", "b", "c");
        String a = "a".join(",", "a","b");
        System.out.println(a);
        // System.out.println(join);

        // 我拍的
        String collect = list1.stream().map(Admin::getAccount)
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);

    }
}
