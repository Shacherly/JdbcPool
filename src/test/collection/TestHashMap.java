package test.collection;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println(map.put(1, 1));
        System.out.println(map.put(null, null));
        System.out.println(map.put(2, 2));
    }
}
