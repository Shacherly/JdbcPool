package test.collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TestHashSet {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5, 6));

        boolean b = set1.retainAll(set2);
        boolean b1 = set1.removeAll(set2);
        System.out.println(set1);
        System.out.println(set2);

    }
}
