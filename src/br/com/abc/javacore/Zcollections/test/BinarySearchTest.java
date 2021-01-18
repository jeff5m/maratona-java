package br.com.abc.javacore.Zcollections.test;

import br.com.abc.javacore.Zcollections.classes.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(0);
        numbers.add(4);
        numbers.add(3);
//        A Binary Search returns the index of the value(key) that is been searched
//        Before creating a Binary Search, the list must be sorted. Otherwise the result isn't reliable.
//        The insertion order of a Binary Search is:
//          if the value has been found, its index will be returned
//          else, the rule to calculate the index is: (-(insertion point) - 1). The value can't be 0 because that is an array's valid index.
//            insertion point == index where the key searched should be insert tho keep the list sorted
        Collections.sort(numbers);
//        index: 0 1 2 3
//        value: 0 2 3 4
//        Its possible to get the value searched passing the index searched as argument in .get(). This value must be checked to make sure it is a valid index
        System.out.println(Collections.binarySearch(numbers, 2));
        System.out.println(numbers.get(1));
        System.out.println("--------------------------------");

        List<Product> products = new ArrayList<>();
        Product product1 = new Product("123", "Laptop Lenovo", 2000.0);
        Product product2 = new Product("321", "Contra-file", 45.0);
        Product product3 = new Product("879", "Teclado Razer", 1000.0);
        Product product4 = new Product("012", "Samsung Galaxy S7 64GB", 3250.5);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);

//        If .sort() uses a Comparator, that comparator must be used in the Binary Search as well
        Collections.sort(products, new ProductNameComparator());
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("--------------------------------");

        Product product5 = new Product("000", "Antena", 50.0);
//        The return of this will be -1, (-(0) - 1). The index of insertion will be 0, since "Antena" will be the first product.
        System.out.println(Collections.binarySearch(products, product5, new ProductNameComparator()));
        System.out.println("--------------------------------");

//        The same applies to Arrays. The return of this will be -2, (-(1) - 1). The index of insertion will be 0, since "Antena" will be the first product.
        Integer[] arr = new Integer[4];
        arr[0] = 2;
        arr[1] = 0;
        arr[2] = 4;
        arr[3] = 3;
        Arrays.sort(arr);
        System.out.println(Arrays.binarySearch(arr, 1));
    }
}
