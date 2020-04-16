package test.date;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestLocalDate {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(String.valueOf(LocalDate.now()).substring(0, 7));
    }

    @Test
    public void test1() {
        LocalDate today = LocalDate.now();
        System.out.println(today);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        // date.format(DateTimeFormatter.ISO_DATE);
        // System.out.println(date.format(formatter));
        System.out.println(formatter.format(today));

        System.out.println(today.withYear(1900).format(formatter));
    }
}
