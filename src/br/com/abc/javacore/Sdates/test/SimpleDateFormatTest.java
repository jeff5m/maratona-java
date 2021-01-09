package br.com.abc.javacore.Sdates.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SimpleDateFormatTest {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        String dateMask = "'data completa': yyyy.MM.dd G 'at' HH:mm:ss z";
        SimpleDateFormat dateFormatter = new SimpleDateFormat(dateMask);
        System.out.println(dateFormatter.format(c.getTime()));
    }
}
