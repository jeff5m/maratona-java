package br.com.abc.javacore.Sdates.test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatTest {
    public static void main(String[] args) {
        float value = 123.3227f;
        Locale localeFrance = new Locale("fr");
        NumberFormat[] numberFormats = new NumberFormat[4];
        numberFormats[0] = NumberFormat.getInstance();
        numberFormats[1] = NumberFormat.getInstance(localeFrance);
        numberFormats[2] = NumberFormat.getCurrencyInstance();
        numberFormats[3] = NumberFormat.getCurrencyInstance(localeFrance);

        for (NumberFormat nf : numberFormats) {
            System.out.println(nf.format(value));
        }

        NumberFormat nf = NumberFormat.getInstance();
        System.out.println(nf.getMaximumFractionDigits());
        nf.setMaximumFractionDigits(5);
        System.out.println(nf.format(value));

        String stringValue = "123,3227fgd";
        try {
            System.out.println(nf.parse(stringValue));
            nf.setParseIntegerOnly(true);
            System.out.println(nf.parse(stringValue));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
