package br.com.abc.javacore.Zcollections.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListsArrayConversionTest {
    public static void main(String[] args) {
//        List => Array
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(0);
        numbers.add(4);
        numbers.add(3);
        System.out.println(numbers);
        Integer[] numbersArr = new Integer[numbers.size()];
        numbers.toArray(numbersArr);
        System.out.println(Arrays.toString(numbersArr));
        System.out.println("-------------------------------");

//        Array => List
        Integer[] numbersArr2 = new Integer[]{12, 11, 14, 13};
//        Should be use with careful because both the array and the list are bind to the same memory address.
//        The operation executed in one of them will replicate in the other. Instead, we can instantiate a new List and pass the previous list
//        as a argument to this new list. This will copy the values.
        List<Integer> numbers2 = Arrays.asList(numbersArr2);
        List<Integer> numbers3 = new ArrayList<>(numbers2);
        numbers3.add(56);
        System.out.println(numbers2);
        System.out.println(numbers3);
        System.out.println(Arrays.toString(numbersArr2));
    }
}
