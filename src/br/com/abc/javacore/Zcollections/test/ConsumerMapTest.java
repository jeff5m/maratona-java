package br.com.abc.javacore.Zcollections.test;

import br.com.abc.javacore.Zcollections.classes.Consumer;
import br.com.abc.javacore.Zcollections.classes.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsumerMapTest {
    public static void main(String[] args) {
        Consumer consumer1 = new Consumer("Jeff", "123");
        Consumer consumer2 = new Consumer("DevDojo", "456");
        Consumer consumer3 = new Consumer("DevDojo222", "456");

        Product product1 = new Product("123", "Laptop Lenovo", 2000.0);
        Product product2 = new Product("321", "Contra-file", 45.0);
        Product product3 = new Product("879", "Teclado Razer", 1000.0);
        Product product4 = new Product("012", "Samsung Galaxy S7 64GB", 3250.5);

//        To store multiple values to one key, we can can declare the Value parameter as a List
        Map<Consumer, List<Product>> map = new HashMap<>();

        List<Product> consumerProducts1 = new ArrayList<>();
        consumerProducts1.add(product1);
        consumerProducts1.add(product2);

        List<Product> consumerProducts2 = new ArrayList<>();
        consumerProducts2.add(product3);
        consumerProducts2.add(product4);

        map.put(consumer1, consumerProducts1);
        map.put(consumer2, consumerProducts2);
//        map.put(consumer3, consumerProducts1); -> Don't change the key because it already exists. But Overrides the values

        for (Map.Entry<Consumer, List<Product>> entry : map.entrySet()) {
            System.out.println(entry.getKey().getName());
            for (Product product : entry.getValue()) {
                System.out.println("  " + product.getName());
            }
        }
    }
}
