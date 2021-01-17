package br.com.abc.javacore.Zcollections.test;

import br.com.abc.javacore.Zcollections.classes.Product;

import java.util.*;

class ProductNameComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

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
/*
        To sort the list of products, we need to implement Comparable in our Product class and override method
        compareTo using our own rule of comparison. Its not the best option when we need to change the sort criteria,
        because the code of others who already used or code in the previous version will break.
*/
        Collections.sort(products);
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("------------------------------------");

//        If the sort criteria needs to change, its a better choice to use the Comparator interface.
        Collections.sort(products, new ProductNameComparator());
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("------------------------------------");

//        We can also sort arrays using the class Arrays, which also allow us to print an array more easily.
        Product[] productsArr = new Product[4];
        productsArr[0] = product1;
        productsArr[1] = product2;
        productsArr[2] = product3;
        productsArr[3] = product4;
        Arrays.sort(productsArr);
        System.out.println(Arrays.toString(productsArr));
        Arrays.sort(productsArr, new ProductNameComparator());
        System.out.println(Arrays.toString(productsArr));
    }
}
