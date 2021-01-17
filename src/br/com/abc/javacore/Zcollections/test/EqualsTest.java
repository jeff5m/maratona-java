package br.com.abc.javacore.Zcollections.test;

import br.com.abc.javacore.Zcollections.classes.Smartphone;

public class EqualsTest {
    public static void main(String[] args) {
        String name1 = "Jeff Pereira";
        String name2 = new String("Jeff Pereira");
        Integer n1 = 5;
        Integer n2 = new Integer(5);
        System.out.println(name1 == name2);
        System.out.println(n1 == n2);
        System.out.println(name1.equals(name2));
        System.out.println(n1.equals(n2));
        System.out.println("-------------------------");

        Smartphone s1 = new Smartphone("iPhone", "12345");
        Smartphone s2 = new Smartphone("iPhone", "12345");
        System.out.println(s2.equals(s1));

    }
}
