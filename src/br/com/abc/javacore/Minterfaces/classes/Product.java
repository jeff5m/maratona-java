package br.com.abc.javacore.Minterfaces.classes;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Product implements Taxable, Transportable {
    NumberFormat formatter = new DecimalFormat("#0.00");
    private String name;
    private double weight;
    private double price;
    private double finalPrice;
    private double freightValue;

    @Override
    public void calculateTax() {
        this.finalPrice = this.price + (this.price * TAX);
    }

    @Override
    public void calculateFreight() {
        this.freightValue = this.price / weight * 0.1;
    }

    public Product(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + formatter.format(price) +
                ", finalPrice with taxes=" + formatter.format(finalPrice) +
                ", freightValue=" + String.format("%.2f", freightValue) +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public double getFreightValue() {
        return freightValue;
    }
}
