package br.com.abc.javacore.ZZAgenerics.test;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest {
    public static void main(String[] args) {
//        Generics <> only exists in compile time. That means that the restriction about types that can be added to it
//        is only valid in compile time. In runtime, the list in the example accepts any data type. This is call Type
//        Erasure, enforcing type constraints only at compile time and discarding the element type information
//        at runtime, replacing by Object.
        List<String> list = new ArrayList<>();
        list.add("string");
        list.add("string2");
        list.add("DevDojo");
        for (String string : list)
            System.out.println(string);

//        The add method adds a Long into "list", because we pass a generic list as argument and add a new element
//        in this generic list, bypassing the generic restriction. When we print the size of this List, we can see that
//        now it does have 4 elements.
        add(list, 1L);
        System.out.println(list.size());

//        If wu try to print that list a ClassCastException will be threw because this for uses a reference variable
//        String and list has one Long element.
//        for (String string : list)
//            System.out.println(string);

    }
    private static void add(List list, Long l) {
        list.add(l);
    }
}
