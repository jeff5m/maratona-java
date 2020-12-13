package br.com.abc.javacore.Fstaticmodifier.test;

import br.com.abc.javacore.Fstaticmodifier.classes.Car;

public class CarTest {
    public static void main(String[] args) {
        Car c1 = new Car("Volvo", 260);
        Car c2 = new Car("BMW", 280);
        Car c3 = new Car("Audi", 295);

        c1.print();
        c2.print();
        c3.print();

        System.out.println("\n");

        /* using an instance of the Car class will have the same effect.
           However, it can cause confusion, as it will pass the idea
           that only this object will be altered, when in fact, the modification will
           have effect on all instances of the class.
         */

        Car.setLimitSpeed(300);
        c1.print();
        c2.print();
        c3.print();
    }
}
