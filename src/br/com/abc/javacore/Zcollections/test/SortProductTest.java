package br.com.abc.javacore.Zcollections.test;

import br.com.abc.javacore.Zcollections.classes.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortProductTest {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product("123", "Laptop Lenovo", 2000.0);
        Product product2 = new Product("321", "Contra-file", 45.0);
        Product product3 = new Product("879", "Teclado Razer", 1000.0);
        Product product4 = new Product("012", "Samsung Galaxy S7 64GB", 3250.5);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
//        To sort the list of products, we need to implement Comparable in our Product class and override method
//        compareTo using our own rule of comparison.
//        Its not the best option to sort a list because if we need to change its implementation in the list's class,
//        the code of others who already used or code in the previous version will break.
        Collections.sort(products);
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
