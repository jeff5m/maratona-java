package br.com.abc.javacore.ZZMdatetime.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class DateTimeAPITest3 {
    public static void main(String[] args) {
        System.out.println("-------- LocalDate --------");
        LocalDate localDate = LocalDate.of(2017, Month.FEBRUARY, 25);
        System.out.println(localDate);
//        classes of this new API are immutable
        localDate = localDate.withYear(2021);
        System.out.println(localDate);
//        changing the month
        localDate = localDate.withMonth(Month.AUGUST.getValue());
        System.out.println(localDate);

        localDate = localDate.withDayOfMonth(20);
        System.out.println(localDate);

        localDate = localDate.with(ChronoField.DAY_OF_MONTH, 15);
        System.out.println(localDate);

        localDate = localDate.plusMonths(5);
        System.out.println(localDate);

        localDate = localDate.plus(5, ChronoUnit.MONTHS);
        System.out.println(localDate);

        localDate = localDate.plusMonths(5).minusDays(26);
        System.out.println(localDate);

        System.out.println("-------- LocalTime --------");
        LocalTime time = LocalTime.now();
        System.out.println(time);

        time = time.withHour(10);
        System.out.println(time);

        time = time.plusHours(15);
        System.out.println(time);

        time = time.plusHours(5).minusMinutes(30) ;
        System.out.println(time);
    }
}
