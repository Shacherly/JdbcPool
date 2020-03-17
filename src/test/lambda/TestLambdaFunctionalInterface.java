package test.lambda;

import com.duing.domain.Admin;
import test.lambda.functionalInterface.Executor;
import test.lambda.functionalInterface.NameChecker;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TestLambda {
    public static void main(String[] args) {
        List<Admin> admins = Arrays.asList(new Admin("aaa"), new Admin("bbb"),
                new Admin("ccc"));
        checkAndExecute1(
                admins,
                admin -> admin.getAccount().startsWith("a"),
                admin -> System.out.println(admin.getAccount())
        );

        checkAndExecute2(
                admins,
                admin -> admin.getAccount().startsWith("a"),
                admin -> System.out.println(admin.getAccount())
        );

        admins.stream().filter(a -> a.getAccount().startsWith("a"))
                .forEach(System.out::print);


    }

    public static void checkAndExecute1(List<Admin> admins, NameChecker<Admin> nameChecker, Executor<Admin> executor) {
        for (Admin admin : admins) {
            if (nameChecker.check(admin)) {
                executor.execute(admin);
            }
        }
    }

    /**
     * 优化
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
