package test.bytes;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String s = "a";
        byte[] bytes = getBytes(new char[]{'我'});
        // byte[] bytes = s.getBytes();
        for (byte aByte : bytes) {
            String s1 = Integer.toBinaryString(aByte);
            System.out.println(s1);
        }
        System.out.println(Arrays.toString(bytes));
    }

    private static byte[] getBytes(char[] chars) {
        Charset cs = StandardCharsets.UTF_8;
        CharBuffer cb = CharBuffer.allocate(chars.length);
        cb.put(chars);
        cb.flip();
        ByteBuffer bb = cs.encode(cb);
        return bb.array();

    }
}
