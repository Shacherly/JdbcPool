package test.lambda;


import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;

public class Lambda1 {
    // 箭头左侧是参数列表，右侧是执行代码
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("run");
        runnable.run();

        String[] str1 = {"acc", "ade", "abb"};
        class LengthComparator implements Comparator<String> {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        }
        Arrays.sort(str1, new LengthComparator());
        System.out.println(Arrays.toString(str1));

        Comparator<String> comparator = (o1, o2) -> o2.length() - o1.length();
        Arrays.sort(str1, comparator);
        System.out.println(Arrays.toString(str1));

        Arrays.sort(str1);
        System.out.println(Arrays.toString(str1));

    }

}
