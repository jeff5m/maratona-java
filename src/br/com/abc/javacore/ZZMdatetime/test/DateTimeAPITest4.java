package br.com.abc.javacore.ZZMdatetime.test;

import br.com.abc.javacore.ZZMdatetime.util.GetNextUsefulDay;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class DateTimeAPITest4 {
    public static void main(String[] args) {
        System.out.println("-------- TemporalAdjuster --------");
        LocalDate date = LocalDate.now();
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        date = date.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        date = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        date = date.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        date = date.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        date = date.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        date = date.with(TemporalAdjusters.firstDayOfNextYear());
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        date = date.with(new GetNextUsefulDay());
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        date = date.plusDays(4);
        System.out.println(date);
        System.out.println(date.getDayOfWeek());

        date = date.with(new GetNextUsefulDay());
        System.out.println(date);
        System.out.println(date.getDayOfWeek());
    }

}
