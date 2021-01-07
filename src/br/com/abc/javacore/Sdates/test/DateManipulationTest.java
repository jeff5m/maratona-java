package br.com.abc.javacore.Sdates.test;

import java.util.Calendar;
import java.util.Date;

public class DateManipulationTest {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.getTime()); // value in milliseconds
        System.out.println(date);

        Calendar cal = Calendar.getInstance(); // calendar is an abstract class. To generate one, use this method
        cal.setTime(date);
        System.out.println(cal);
        System.out.println(cal.getTime());
        if(Calendar.SUNDAY == cal.getFirstDayOfWeek()) {
            System.out.println("Domingo eh o primeiro dia da semana");
        }
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));
        System.out.println(cal.get(Calendar.DAY_OF_WEEK));
        System.out.println(cal.get(Calendar.DAY_OF_YEAR));
        cal.add(Calendar.HOUR, 24); // .add change all date data to adjust to information received
        cal.roll(Calendar.MONTH, 14); // .roll change only the specified field
        Date date2 = cal.getTime();

        System.out.println(date2);

        // Classes to format date and currency
        // NumberFormat, Locale, Calendar, Date, DateFormat

    }
}
