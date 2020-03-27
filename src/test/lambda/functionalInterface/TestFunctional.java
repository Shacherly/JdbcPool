package test.lambda.functionalInterface;

import com.duing.domain.User;
import com.google.gson.Gson;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestFunctional {
    public static void main(String[] args) {
        // MyInterface print2 = x -> {
        //     System.out.println(x);
        //     System.out.println(x);
        // };
        //
        // MyInterface print1 = System.out::println;
        //
        // print1.doThings("打印一遍？");
        // print2.doThings("打印两遍？");
        System.out.println(get(() -> {
            String s = "asdsad";
            return s.toUpperCase();
        }));
        System.out.println(test1("???", x -> x.contains("?")));
        System.out.println(isEmptyCollection(new ArrayList<>(), Collection::isEmpty));

        List<User> list = Arrays.asList(new User(1L, "u1"), new User(2L, "u2"));
        String json = new Gson().toJson(list);
        System.out.println("这是JSON：" + json);
        System.out.println(parse2List(json, s -> Arrays.asList(new Gson().fromJson(s, User[].class))));
    }


    // 定义方法

    /**
     * 供应型接口，无参有返。
     * @param supplier
     * @return
     */
    public static String get(Supplier<String> supplier) {
        return supplier.get();
    }

    public static boolean test1(String obj, Predicate<String> predicate) {
        return predicate.test(obj);
    }

    public static boolean isEmptyCollection(Collection<?> collection, Predicate<Collection<?>> predicate) {
        return predicate.test(collection);
    }

    public static <T> List<T> parse2List(String json, Function<String, List<T>> function) {
        return function.apply(json);
    }


}
