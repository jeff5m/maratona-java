package br.com.abc.javacore.Sdates.test;

import java.text.DateFormat;
import java.util.Calendar;

public class DateFormatTest {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        DateFormat[] formattedDate = new DateFormat[6];
        formattedDate[0] = DateFormat.getInstance();
        formattedDate[1] = DateFormat.getDateInstance();
        formattedDate[2] = DateFormat.getDateInstance(DateFormat.SHORT);
        formattedDate[3] = DateFormat.getDateInstance(DateFormat.MEDIUM);
        formattedDate[4] = DateFormat.getDateInstance(DateFormat.LONG);
        formattedDate[5] = DateFormat.getDateInstance(DateFormat.FULL);

        System.out.println(DateFormat.getDateInstance().format(c.getTime()));

        for(DateFormat date : formattedDate) {
            System.out.println(date.format(c.getTime()));
        }

    }
}
