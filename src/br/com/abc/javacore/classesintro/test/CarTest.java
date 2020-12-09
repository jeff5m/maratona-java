package br.com.abc.javacore.classesintro.test;

import br.com.abc.javacore.classesintro.classes.Car;

public class CarTest {
    public static void main(String[] args) {
        Car car = new Car();
        car.model = "Chevette";
        car.plate = "ASD1234";
        car.maximumSpeed = 145f;
        System.out.println(car.model);
        System.out.println(car.plate);
        System.out.println(car.maximumSpeed);
    }
}
