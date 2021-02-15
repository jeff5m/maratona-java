package br.com.abc.javacore.ZZMdatetime.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;

public class DateTimeAPITest1 {
    public static void main(String[] args) {
        System.out.println("-------- LocalDate --------");
        LocalDate date = LocalDate.of(2021, Month.NOVEMBER, 1);
        System.out.println(date.getYear());
        System.out.println(date.getMonth() + " numero do mes: " + date.getMonthValue());
        System.out.println(date.getDayOfMonth());
        System.out.println(date.getDayOfWeek());
        System.out.println(date.lengthOfMonth());
        System.out.println(date.isLeapYear());
        System.out.println(date.get(ChronoField.YEAR));
        System.out.println(date.get(ChronoField.DAY_OF_MONTH));
        LocalDate now = LocalDate.now();
        System.out.println(date);
        System.out.println(now);
        System.out.println(LocalDate.MAX);
        System.out.println(LocalDate.MIN);

        System.out.println("-------- LocalTime --------");
        LocalTime time = LocalTime.of(23, 45, 18);
        System.out.println(time);
        System.out.println(time.getSecond());
        System.out.println(time.getMinute());
        System.out.println(time.getHour());
        System.out.println(LocalTime.MAX);
        System.out.println(LocalTime.MIN);
        System.out.println("LocalTime:");

        System.out.println("-------- Parse --------");
        LocalDate parseDate = LocalDate.parse("2021-02-15");
        LocalTime parseTime = LocalTime.parse("07:11:15");
        System.out.println(parseDate);
        System.out.println(parseTime);

        System.out.println("-------- LocalDateTime --------");
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.of(2012, Month.OCTOBER, 26, 11,55, 49);
        LocalDateTime localDateTime3 = date.atTime(20,40,50);
        LocalDateTime localDateTime4 = date.atTime(LocalTime.now());
        LocalDateTime localDateTime5 = time.atDate(LocalDate.now());
        LocalDateTime localDateTime6 = time.atDate(date);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);
        System.out.println(localDateTime3);
        System.out.println(localDateTime4);
        System.out.println(localDateTime5);
        System.out.println(localDateTime6);
    }
}
