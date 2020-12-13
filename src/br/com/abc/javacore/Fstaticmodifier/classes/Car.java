package br.com.abc.javacore.Fstaticmodifier.classes;

public class Car {
    private String name;
    private double maxSpeed;
    private static double limitSpeed = 240;

    public Car(String name, double maxSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    public Car() {

    }

    public void print() {
        System.out.println("-------------------------------");
        System.out.println("Nome: " + this.name);
        System.out.println("Velocidade: " + this.maxSpeed);
        System.out.println("Limite: " + limitSpeed);
    }

    public static void setLimitSpeed(double limitSpeed) {
        Car.limitSpeed = limitSpeed;
    }

    public static double getLimitSpeed() {
        return Car.limitSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
