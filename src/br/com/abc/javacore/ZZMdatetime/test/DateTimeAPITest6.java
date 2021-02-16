package br.com.abc.javacore.ZZMdatetime.test;

import br.com.abc.javacore.Gassociation.classes.Local;

import java.time.*;
import java.time.chrono.JapaneseDate;
import java.util.Map;

public class DateTimeAPITest6 {
    public static void main(String[] args) {
        Map<String, String> shortIds = ZoneId.SHORT_IDS;
        for (Map.Entry<String, String> zones : shortIds.entrySet()) {
            System.out.println(zones.getKey() + " " + zones.getValue());
        }
        System.out.println("----------------");
        System.out.println(ZoneId.systemDefault());
        ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");
        System.out.println(tokyoZone);

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        ZonedDateTime zonedDateTime = dateTime.atZone(tokyoZone);
        System.out.println(zonedDateTime);

        System.out.println("----------------");
        Instant instant = Instant.now();
        System.out.println(instant);
        ZonedDateTime zonedDateTime2 = instant.atZone(tokyoZone);
        System.out.println(zonedDateTime2);

        System.out.println("----------------");
        System.out.println(ZoneOffset.MAX);
        System.out.println(ZoneOffset.MIN);
        ZoneOffset manausOffSet = ZoneOffset.of("-04:00");
        LocalDateTime dateTime2 = LocalDateTime.now();
//        two next method has the same result
        OffsetDateTime offsetDateTime1 = OffsetDateTime.of(dateTime2, manausOffSet);
        OffsetDateTime offsetDateTime2 = dateTime2.atOffset(manausOffSet);
        System.out.println(offsetDateTime1);
        System.out.println(offsetDateTime2);
        Instant instant2 = Instant.now();
        System.out.println(instant2.atOffset(manausOffSet));

        System.out.println("----------------");
        JapaneseDate japaneseDate = JapaneseDate.from(LocalDate.now());
        System.out.println(japaneseDate);
        LocalDate oldDay = LocalDate.of(1900, Month.FEBRUARY, 1);
        System.out.println(JapaneseDate.from(oldDay));

    }
}
