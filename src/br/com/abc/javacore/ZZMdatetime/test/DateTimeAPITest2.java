package br.com.abc.javacore.ZZMdatetime.test;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DateTimeAPITest2 {
    public static void main(String[] args) {
        System.out.println("-------- Instant --------");
//        useful in dates processing because its very precise, returning nanoseconds
        Instant instant = Instant.now();
        System.out.println(instant);  // UTC
        System.out.println(LocalDateTime.now());
        System.out.println(instant.getEpochSecond()); // get the seconds
        System.out.println(instant.getNano()); // get the nanoseconds max 999_999_999
        System.out.println(Instant.ofEpochSecond(3));
        System.out.println(Instant.ofEpochSecond(3, 10));

        System.out.println("-------- Duration --------");
        LocalDateTime ldt1 = LocalDateTime.now();
        LocalDateTime ldt2 = LocalDateTime.of(2021, Month.JANUARY, 1, 23, 0, 0);
        LocalTime time1 = LocalTime.now();
        LocalTime time2 = LocalTime.of(5, 0, 0);

        Duration d1 = Duration.between(ldt1, ldt2);
        Duration d2 = Duration.between(time1, time2);
        Duration d3 = Duration.between(Instant.now(), Instant.now().plusSeconds(1000));
//       can't use LocalDate for lack of precision
//        can't mix LocalDateTime with LocalTime
//        Duration d4 = Duration.between(ldt2, time2);
//        Duration d5 = Duration.between(LocalDate.now(), LocalDate.now().plusDays(20));
        Duration d6 = Duration.between(ldt2, time2.atDate(ldt2.toLocalDate()));
        Duration d7 = Duration.ofMinutes(3);
        Duration d8 = Duration.ofDays(10); // return value in hrs

        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
//        System.out.println(d4);
//        System.out.println(d5);
        System.out.println(d6);
        System.out.println(d7);
        System.out.println(d8);

        System.out.println("-------- Period --------");
        Period p1 = Period.between(ldt1.toLocalDate(), ldt2.toLocalDate());
        Period p2 = Period.ofDays(10);
        Period p3 = Period.ofWeeks(58); // return in days
        Period p4 = Period.ofYears(3);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
//        System.out.println(Period.between(LocalDate.now(), LocalDate.now().plusDays(p3.getDays())));
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.until(now.plusDays(p3.getDays()), ChronoUnit.MONTHS));

        System.out.println("-------- ChronoUnit --------");
        LocalDateTime birthday = LocalDateTime.of(1975, Month.AUGUST, 23, 12, 0, 0);
        System.out.println(ChronoUnit.DAYS.between(birthday, now));
        System.out.println(ChronoUnit.WEEKS.between(birthday, now));
        System.out.println(ChronoUnit.MONTHS.between(birthday, now));
        System.out.println(ChronoUnit.YEARS.between(birthday, now));

    }
}
