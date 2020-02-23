package test;

import java.util.Arrays;
import java.util.LinkedList;

public class BitAdder {
    public static void main(String[] args) {
        String i = Integer.toBinaryString(10);
        System.out.println(i);
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.addFirst("b");
        linkedList.addFirst("c");
        System.out.println(linkedList);
        System.out.println(1 & 1);

    }

    public static Byte adder(String a, String b, String cIn) {
        int aL = a.length();
        int bL = b.length();
        int max = Math.max(aL, bL);

        // if (arr == null) {
        //     return null;
        // }
        LinkedList<Byte> linkedList = new LinkedList<>();
        byte sum = 0;
        // linkedList.add(sum);
        // arr[0]  arr[1]  arr[2]
        // Byte[] handler = handler(Byte.valueOf(arr[0]), Byte.valueOf(arr[1]), Byte.valueOf(arr[2]));
        // assert handler != null;
        // linkedList.add(handler[1]);
        return null;
    }

    public static Byte[] handler(Byte a, Byte b, Byte cIn) {
        int sum = a + b + cIn;
        if (sum % 2 == 1) {
            return new Byte[]{0, 1};
        }
        if (sum == 2) {
            return new Byte[]{1, 0};
        }
        if (sum == 3) {
            return new Byte[]{1, 1};
        }
        if (sum == 0) {
            return new Byte[]{0, 0};
        }
        return null;
    }

}
