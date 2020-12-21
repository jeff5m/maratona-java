package br.com.abc.javacore.Jfinalmodifier.test;

import br.com.abc.javacore.Jfinalmodifier.classes.Car;
import br.com.abc.javacore.Jfinalmodifier.classes.Subaru;

public class CarTest {
    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car.getBuyer());
        car.getBuyer().setName("Lee Canien");
        System.out.println(car.getBuyer());

        Subaru car1 = new Subaru();

        System.out.println(car1.toString(car1.getName(), car1.getBrand()));
    }
}
