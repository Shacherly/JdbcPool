package test.lambda;

import com.duing.domain.Admin;
import test.lambda.functionalInterface.Executor;
import test.lambda.functionalInterface.NameChecker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TestLambdaFunctionalInterface {
    public static void main(String[] args) {
        List<Admin> admins = new ArrayList<>(
                Arrays.asList(new Admin("aaa"), new Admin("bbb"),new Admin("ccc"))
        );
        // 原始方法
        checkAndExecute1(
                admins,
                admin -> admin.getAccount().startsWith("a"),
                admin -> System.out.println(admin.getAccount())
        );

        // 优化方法
        checkAndExecute2(
                admins,
                admin -> !admin.getAccount().startsWith("a"),
                admin -> System.out.println(admin.getAccount())
        );

        // Stream类方法
        admins.stream().filter(a -> a.getAccount().startsWith("a"))
                .forEach(System.out::println);

        List<Admin> result = new ArrayList<>();
        admins.stream().filter(r -> r.getAccount().startsWith("a"))
                .forEach(result::add);
        System.out.println(result);


    }

    /**
     * 原始方法，使用自定义的两个函数式接口
     * @param admins
     * @param nameChecker
     * @param executor
     */
    public static void checkAndExecute1(List<Admin> admins, NameChecker<Admin> nameChecker, Executor<Admin> executor) {
        for (Admin admin : admins) {
            if (nameChecker.check(admin)) {
                executor.execute(admin);
            }
        }
    }

    /**
     * 优化，实际上JDK已经提供了两个函数式接口
     * @param admins
     * @param predicate
     * @param consumer
     */
    public static void checkAndExecute2(
            List<Admin> admins, Predicate<Admin> predicate, Consumer<Admin> consumer) {

        admins.forEach(admin -> {
            if (predicate.test(admin)) {
                consumer.accept(admin);
            }
        });
    }
}
