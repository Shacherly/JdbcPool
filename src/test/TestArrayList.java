package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.Lock;

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        for (Integer integer : list) {
            if (4 == integer) {
                list.add(1);
            }
        }
        CopyOnWriteArrayList<Integer> arrayList = new CopyOnWriteArrayList<>();
        // CopyOnWriteArraySet


    }
}
