package br.com.abc.javacore.Zcollections.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortListTest {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Jeff");
        names.add("Pereira");
        names.add("Lee");
        names.add("Breno");
        names.add("DevDojo");
//        We can pass the index where the new value will be insert
        names.add(0,"Anna");
//        Utility class that has a .sort(). This method receive a List as argument, changing the items indexes, sorting
//        them in ascendant order. It can also receive a comparator. This works with wrapper classes because they implement
//        Comparable interface, which tells how to sort that class using some Java sort algorithm.
        Collections.sort(names);
        names.forEach(System.out::println);
        System.out.println("------------");

        List<Double> numbers = new ArrayList<>();
        numbers.add(34.34);
        numbers.add(42.56);
        numbers.add(54.01);
        numbers.add(74.1);
        numbers.add(0.98);
        numbers.add(2D);
        Collections.sort(numbers);
        for (Double number : numbers) {
            System.out.println(number);
        }
    }
}
