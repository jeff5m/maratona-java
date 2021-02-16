package br.com.abc.javacore.ZZMdatetime.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeAPITest5 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = date.format(DateTimeFormatter.ISO_DATE);
        String s3 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        String s4 = "20210215"; // not accept by the basic parse
        String s5 = "2021-02-15+05:00";
        LocalDate parse1 = LocalDate.parse(s4, DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate parse2 = LocalDate.parse(s5, DateTimeFormatter.ISO_DATE);
        System.out.println(parse1);
        System.out.println(parse2);

        LocalDateTime dateTime = LocalDateTime.now();
        String s6 = dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(s6);

        LocalDateTime parse3 = LocalDateTime.parse("2021-02-15T22:14:32.594232");
        System.out.println(parse3);

//        to format date in a specific pattern. That pattern can be use string to date and vice-versa
        DateTimeFormatter formatterBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatBR = LocalDate.now().format(formatterBR);
        System.out.println(formatBR);
        String dateBR = "01/03/2020";
        LocalDate parseDateBR = LocalDate.parse(dateBR, formatterBR);
        System.out.println(parseDateBR);

        DateTimeFormatter formatterFR = DateTimeFormatter.ofPattern("dd.MMMM.yyyy", Locale.FRANCE);
        String formatFR = LocalDate.now().format(formatterFR);
        System.out.println(formatFR);
        LocalDate parseDateFR = LocalDate.parse("15.février.2021", formatterFR);
        System.out.println(parseDateFR);
    }
}
