package test.lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;

public class Lambda3 {
    public static void main(String[] args) {
        // System.out.println(String.join(", ", Arrays.asList("a", "b", "c")));
        List<String> list = new CopyOnWriteArrayList<>(Arrays.asList("a", "b", "c", "b", "c", "b", "c", "b", "c", "b", "c", "b", "c", "b", "c", "b", "c", "b", "c"));
        // list.forEach(x -> System.out.print(x));
        //
        // list.stream().filter(s -> {
        //     if (s.equals("b"))
        //         return true;
        //     return false;
        // }).forEach(System.out::println);

        new Thread(() -> {
            list.removeIf(s -> s.equals("b"));
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.forEach(System.out::print);
        }).start();

        System.out.println(list);
    }
}
