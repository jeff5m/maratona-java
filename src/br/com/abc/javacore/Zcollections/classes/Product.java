package br.com.abc.javacore.Zcollections.classes;

import org.jetbrains.annotations.NotNull;

public class Product implements Comparable<Product> {

    private String serialNumber;
    private String name;
    private Double price;
    private int quantity;

    public Product(String serialNumber, String name, Double price) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.price = price;
    }

    public Product(String serialNumber, String name, Double price, int quantity) {
        this(serialNumber, name, price);
        this.quantity = quantity;
    }

    @Override
    public int compareTo(@NotNull Product o) {
//        Will return a negative number if this < o
//        Will return 0 if this == o
//        Will return a positive number if this > o
//        As serialNumber is a string, we can use the .compareTo() strings method to compare them. This
//        logic is applicable to other wrapper classes. This is one of the reasons why use wrapper classes is a good idea
        return this.price.compareTo(o.getPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return serialNumber != null ? serialNumber.equals(product.serialNumber) : product.serialNumber == null;
    }

    @Override
    public int hashCode() {
        return serialNumber != null ? serialNumber.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Product{" +
                "serialNumber='" + serialNumber + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
