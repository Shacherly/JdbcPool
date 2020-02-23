package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMain {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.removeIf(x -> x.equals("1"));
        System.out.println(list);
        Map<String, Object> map = new HashMap<>(16);
        map.put("1", "a");
        map.put("2", "b");
        map.forEach((x, y) -> {
            if ("1".equals(x)) {
                System.out.println(x + "," + y);
            }
        });

    }
}
