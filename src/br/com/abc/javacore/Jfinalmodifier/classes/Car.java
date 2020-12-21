package br.com.abc.javacore.Jfinalmodifier.classes;

public class Car {
    public static final double FINAL_SPEED = 250;
    private final Buyer BUYER = new Buyer();
    private String name;
    private String brand;

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }

    public final void print() {
        System.out.println("Imprimindo um carro");
    }

    public static double getFinalSpeed(){
        return Car.FINAL_SPEED;
    }

    public Buyer getBuyer() {
        return BUYER;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
