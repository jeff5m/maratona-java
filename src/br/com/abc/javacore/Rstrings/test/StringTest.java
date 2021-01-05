package br.com.abc.javacore.Rstrings.test;

import java.util.Locale;

public class StringTest {
    public static void main(String[] args) {
        String name = "Antonio";
        name.concat(" Alberto");
//        String doesn't change
        System.out.println(name);
//        concatenated string
        name = name.concat(" Alberto");
        System.out.println(name);

        String test = "Caio";
        String test2 = "caio";
        String test3 = "0123456789";
        String test4 = "       0123456789        ";
        System.out.println(test.charAt(3));
        System.out.println(test.equals(test2));
        System.out.println(test.equalsIgnoreCase(test2));
        System.out.println(test.length());
        System.out.println(test2.replace('c','p'));
        System.out.println(test2.toUpperCase());
        System.out.println(test3.substring(0,1)); // from the index, bring until position
        System.out.println(test3.substring(0,2));
        System.out.println(test4.trim()); // remove spaces at the beginning and at the end
    }
}
