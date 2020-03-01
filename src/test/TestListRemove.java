package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestListRemove {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        // list1.remove(3);

        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        // list2.add(1);
        // list2.add(2);
        // list2.remove(1);
        list1.removeIf(x -> x.equals(1));
        System.out.println(list2.size());
        System.out.println(list2);
    }
}
