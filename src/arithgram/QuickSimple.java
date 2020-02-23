package arithgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSimple {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(9);
        list.add(2);
        list.add(6);
        list.add(8);
        list.add(7);
        list.add(5);
        List<Integer> integers = quickSort(list);
        System.out.println(integers);
    }

    public static ArrayList<Integer> quickSort(ArrayList<Integer> arr) {
        if (arr == null || arr.size() <= 1) return arr;
        int leader = arr.get(0);
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < leader) left.add(arr.get(i));
            else right.add(arr.get(i));
        }
        ArrayList<Integer> leftRes = quickSort(left);
        ArrayList<Integer> rightRes = quickSort(right);
        ArrayList<Integer> result = new ArrayList<>(leftRes);
        result.add(leader);
        result.addAll(rightRes);
        return result;
    }
}
