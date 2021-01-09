package br.com.abc.javacore.Sdates.test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class LocaleTest {
    public static void main(String[] args) {
        Locale localeUs = new Locale("en", "us");
        Locale localeItaly = new Locale("it", "ca");
        Locale localeJapan = new Locale("ja");
        Locale localeIndia = new Locale("hi", "in");
        Locale localeSwidden = new Locale("ch", "ch");

        Calendar c = Calendar.getInstance();
        c.set(2015, Calendar.DECEMBER,23);

        DateFormat usDateFormat = DateFormat.getDateInstance(DateFormat.FULL, localeUs);
        String UsDate = usDateFormat.format(c.getTime());
        System.out.println("USA: "+UsDate);

        DateFormat italyDateFormat = DateFormat.getDateInstance(DateFormat.FULL, localeItaly);
        String ItalyDate = italyDateFormat.format(c.getTime());
        System.out.println("Italy: "+ItalyDate);

        DateFormat japanDateFormat = DateFormat.getDateInstance(DateFormat.FULL, localeJapan);
        System.out.println("Japan: "+japanDateFormat.format(c.getTime()));

        System.out.println("India: "+DateFormat.getDateInstance(DateFormat.FULL, localeIndia).format(c.getTime()));

        DateFormat swiddenDateFormat = DateFormat.getDateInstance(DateFormat.FULL, localeSwidden);
        System.out.println("Swidden: "+swiddenDateFormat.format(c.getTime()));

        System.out.println(localeJapan.getDisplayLanguage());
        System.out.println(localeJapan.getDisplayLanguage(localeJapan));
        System.out.println(localeSwidden.getDisplayCountry());
        System.out.println(localeSwidden.getDisplayCountry(localeItaly));
    }
}
