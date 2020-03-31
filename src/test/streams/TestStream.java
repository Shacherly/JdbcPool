package test.streams;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class TestStream {
    public static void main(String[] args) {
        Stream<Integer> integer = Stream.of(1, 2, 3, 4);
        System.out.println();
        integer.filter(item -> item != 3).forEach(System.out::println);
        integer.forEach(System.out::println);
        Stream<BigInteger> generate = Stream.generate(new Supplier<BigInteger>() {
            BigInteger next = BigInteger.ZERO;

            @Override
            public BigInteger get() {
                next = next.add(BigInteger.ONE);
                return next;
            }
        });


        // try {
        //     Stream<String> lines = Files.lines(Paths.get("D:\\Project\\DUYI_EDU\\JdbcPool\\src\\test\\streams\\TestStream.java"));
        //     System.out.println();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }


    }
}
