package br.com.abc.javacore.Zcollections.test;

import br.com.abc.javacore.Zcollections.classes.Product;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Product product1 = new Product("123", "Laptop Lenovo", 2000.0, 10);
        Product product2 = new Product("321", "Contra-file", 45.0, 10);
        Product product3 = new Product("879", "Teclado Razer", 1000.0, 0);
        Product product4 = new Product("012", "Samsung Galaxy S7 64GB", 3250.5, 0);
        Product product5 = new Product("012", "Samsung Galaxy S6 64GB", 3250.5, 0);
//        One of the main characteristics of the Set is that it does not allow duplicate elements. When we adding a new item
//        he will check with .equals() to see if there is any other product with the same attributes and the .hashCode()
//        to organize the item inside the collection
//        Set also are not indexed and we can't keep insertion order. But, if we need to do that, instead of use HashSet,
//        we can use LinkedHashSet
        Set<Product> productSet = new HashSet<>();
        productSet.add(product1);
        productSet.add(product2);
        productSet.add(product3);
        productSet.add(product4);
        productSet.add(product5);

        for (Product product : productSet) {
            System.out.println(product.getName());
        }
    }
}
