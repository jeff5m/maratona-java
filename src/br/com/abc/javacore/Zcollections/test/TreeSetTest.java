package br.com.abc.javacore.Zcollections.test;

import br.com.abc.javacore.Zcollections.classes.Product;
import br.com.abc.javacore.Zcollections.classes.Smartphone;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

class SmartphoneNameComparator implements Comparator<Smartphone> {

    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class ProductSerialNumberComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getSerialNumber().compareTo(o2.getSerialNumber());
    }
}

public class TreeSetTest {
    public static void main(String[] args) {
        Product product1 = new Product("123", "Laptop Lenovo", 2000.0, 10);
        Product product2 = new Product("321", "Contra-file", 45.0, 10);
        Product product3 = new Product("879", "Teclado Razer", 1000.0, 0);
        Product product4 = new Product("012", "Samsung Galaxy S7 64GB", 3250.5, 0);
        Product product5 = new Product("011", "Samsung Galaxy S6 64GB", 1D, 0);
        Smartphone smartphone1 = new Smartphone("iPhone", "1234");
//        The main advantage of using TreeSet, is that the inserted elements are already sorted automatically
//        To change the original sort rule, we pass a Comparator in te constructor
//        "NavigableSet<Product> productNavigableSet = new TreeSet<>(new ProductSerialNumberComparator());"
        NavigableSet<Product> productNavigableSet = new TreeSet<>();
//        When works with NavigableSet or TreeSet, the class that instantiate objects must have a way to compare those objects
//        In this example we did that crating the class SmartphoneNameComparator
        NavigableSet<Smartphone> smartphoneNavigableSet = new TreeSet<>(new SmartphoneNameComparator());
        smartphoneNavigableSet.add(smartphone1);
        for (Smartphone smartphone : smartphoneNavigableSet) {
            System.out.println(smartphone);
        }
        System.out.println("------------------------------------------------------");

        productNavigableSet.add(product1);
        productNavigableSet.add(product2);
        productNavigableSet.add(product3);
        productNavigableSet.add(product4);
        productNavigableSet.add(product5);

        for (Product product : productNavigableSet) {
            System.out.println(product);
        }
        System.out.println("------------------------------------------------------");
//        Methods:
//        .lower() == <, .floor() <=, .higher() >, .ceiling() >=
//        returns the next element that satisfied the statement
        System.out.println(productNavigableSet.lower(product1));
        System.out.println(productNavigableSet.floor(product1));
        System.out.println(productNavigableSet.higher(product1));
        System.out.println(productNavigableSet.ceiling(product1));
        System.out.println("------------------------------------------------------");

//        To invert the sort order, just call .descendingSet()
        for (Product product : productNavigableSet.descendingSet()) {
            System.out.println(product);
        }
        System.out.println("------------------------------------------------------");

//        .pollFirst() and .pollLast()
//        Returns and remove the first and last elements of the set, respectively
        System.out.println(productNavigableSet.size());
        System.out.println(productNavigableSet.pollLast());
        System.out.println(productNavigableSet.size());
    }
}
