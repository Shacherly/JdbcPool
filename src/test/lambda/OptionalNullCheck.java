package test.lambda;

import com.duing.domain.Admin;

import java.util.Optional;

public class OptionalNullCheck {
    public static void main(String[] args) {


        Admin admin = Admin.build("a");
        Optional<Admin> optional = Optional.ofNullable(admin);
        // 存在则开干
        optional.ifPresent(System.out::println);

        // 存在则返回，没有则返回其他
        System.out.println(optional.orElse(new Admin("new A")));

        // 存在则返回，没有则有供应接口产生
        optional.orElseGet(() -> new Admin("a"));

        // 夺命连环null检查
        // map()就已经是一个if not null为true的情况
        System.out.println(optional.map(Admin::getAccount).map(String::toUpperCase).orElse(null));
    }
}
