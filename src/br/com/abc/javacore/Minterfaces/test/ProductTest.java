package br.com.abc.javacore.Minterfaces.test;

import br.com.abc.javacore.Minterfaces.classes.Product;
import br.com.abc.javacore.Minterfaces.classes.Taxable;

public class ProductTest {
    public static void main(String[] args) {
        Product product = new Product("Notebook", 2.4, 4600);
        product.calculateTax();
        product.calculateFreight();

        System.out.println(product);
    }
}
