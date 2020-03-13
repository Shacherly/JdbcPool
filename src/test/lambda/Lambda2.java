package test.lambda;

import test.lambda.functionalInterface.MyInterface;

import java.util.Arrays;
import java.util.Comparator;

public class Lambda2 {
    public static void main(String[] args) {
        // 常规写法
        // Runnable runnable = new Runnable() {
        //     @Override
        //     public void run() {
        //         System.out.println("runrunrun!!!");
        //     }
        // };
        // runnable.run();

        // lambda写法
        // Runnable runnable1 = () -> System.out.println("Hello Lambda!!!");
        // runnable1.run();

        // 常规写法
        String[] arr = {"abc", "defgh"};
        class LengthComparator implements Comparator<String> {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        }
        Arrays.sort(arr, new LengthComparator());
        System.out.println(Arrays.toString(arr));

        // lambda写法
        Arrays.sort(arr, (o1, o2) -> {
            return o1.length() - o2.length();
        });
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() < o2.length()) return -1;
            else if (o1.length() > o2.length()) return 1;
            return 0;
        });

    }
}
