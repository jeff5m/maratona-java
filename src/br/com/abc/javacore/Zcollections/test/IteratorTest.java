package br.com.abc.javacore.Zcollections.test;

import br.com.abc.javacore.Zcollections.classes.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorTest {
    public static void main(String[] args) {
//        To remove items, is better use LinkedList instead of ArrayList, since its have a better performance in this
//        particular task. The great advantage in Interface Oriented Programming is that we can change the implementation
//        without break the code like done is this code. ArrayList was replaced by LinkedList.
        List<Product> products = new LinkedList<>();
        Product product1 = new Product("123", "Laptop Lenovo", 2000.0, 10);
        Product product2 = new Product("321", "Contra-file", 45.0, 10);
        Product product3 = new Product("879", "Teclado Razer", 1000.0, 0);
        Product product4 = new Product("012", "Samsung Galaxy S7 64GB", 3250.5, 0);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);

//        To remove items from a list in execution time, one of the best options is to use an iterator
        Iterator<Product> productIterator = products.iterator();
        while (productIterator.hasNext()) {
            if (productIterator.next().getQuantity() == 0)
                productIterator.remove();
        }

        System.out.println(products.size());
        System.out.println(products);
    }
}
