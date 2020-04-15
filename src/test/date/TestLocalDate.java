package test.date;

import java.time.LocalDate;

public class TestLocalDate {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(String.valueOf(LocalDate.now()).substring(0, 7));
    }
}
