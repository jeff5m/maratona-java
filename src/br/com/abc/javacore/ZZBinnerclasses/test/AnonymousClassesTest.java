package br.com.abc.javacore.ZZBinnerclasses.test;

import br.com.abc.javacore.ZZAgenerics.classes.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Animal {
    public void walk() {
        System.out.println("Andando");
    }
}

public class AnonymousClassesTest {
    public static void main(String[] args) {
//        Anonymous class are useful because we can make a single instance of a class have overload methods, for example,
//        without the need to subclass the superclass. They work for classes or interfaces.
        Animal animal1 = new Animal() {
            @Override
            public void walk() {
                System.out.println("Andando anonimamente");
            }
        };
        Animal animal2 = new Animal();
        animal1.walk();  // method override in anonymous class
        animal2.walk();  // default method in Animal class

        System.out.println("---------------------------");

        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Edge"));
        carList.add(new Car("BMW"));
//        To sort the list of car, instead of create a new class to compare the elements, we can create a anonymous class
//        inside the Collections.sort()
        Collections.sort(carList, new Comparator<Car>() {

            @Override
            public int compare(Car o1, Car o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        System.out.println(carList);
    }
}

class CarComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getName().compareTo(o2.getName());
    }
}