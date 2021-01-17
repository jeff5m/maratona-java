package br.com.abc.javacore.Zcollections.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Jeff");
        names.add("Pereira");
        names.add("DevDojo");
        System.out.println("Pereira foi removido? " + names.remove("Pereira")); // could also pass the index of the data as argument
        System.out.println("Tamanho da lista: " + names.size());
        System.out.println("-----------------------");
//        We can't change the List size while iterating over it using a forEach because, before the forEach begins its
//        execution, Java already knows its length. But we can change the List size using a traditional for loop
        for (String name : names) {
            System.out.println(name);
        }
//        Does the same that the code above. Was introduced in Java 8
//        names.forEach(System.out::println);
        System.out.println("-----------------------");

//        We can add a collection into another using .addAll()
        List<String> names2 = new ArrayList<>();
        names2.add("Jeff2");
        names2.add("DevDojo2");
        names.addAll(names2);
        System.out.println("Tamanho da lista: " + names.size());
        for(String name : names) {
            System.out.println(name);
        }
        System.out.println("-----------------------");

//        We can clear all the data inside the List using .clear().
        names.clear();
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("-----------------------");

//        We can't create List using primitive data types, because, under the hood, List make calls to methods .equals()
//        and .hashCode() and a primitive data type doesn't have any methods at all. So a wrapper class can be used instead
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(12);
        for (Integer n : numbers) {
            System.out.println(n);
        }

    }
}
