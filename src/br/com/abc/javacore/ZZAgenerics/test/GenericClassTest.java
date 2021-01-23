package br.com.abc.javacore.ZZAgenerics.test;

import br.com.abc.javacore.ZZAgenerics.classes.Car;
import br.com.abc.javacore.ZZAgenerics.classes.Computer;

import java.util.ArrayList;
import java.util.List;

public class GenericClassTest {
    public static void main(String[] args) {
        List<Car> availableCars = new ArrayList<>();
        availableCars.add(new Car("BMW"));
        availableCars.add(new Car("Volvo"));
        RentableObjects<Car> rentableCars = new RentableObjects<>(availableCars);
        Car rentedCar = rentableCars.getAvailableObject();
        rentableCars.returnObject(rentedCar);

        System.out.println("-----------------------------------------------------------------------");

        List<Computer> availableComputers = new ArrayList<>();
        availableComputers.add(new Computer("System76"));
        availableComputers.add(new Computer("Dell"));
        RentableObjects<Computer> rentableComputers = new RentableObjects<>(availableComputers);
        Computer computer = rentableComputers.getAvailableObject();
        rentableComputers.returnObject(computer);
    }
}

// <T> will be replaced by the Class that will be passed. Working with Lists, <E> from element is used.
class RentableObjects<T> {
    private List<T> availableObjects;

    public RentableObjects(List<T> availableObjects) {
        this.availableObjects = availableObjects;
    }

    public T getAvailableObject() {
        T object = availableObjects.remove(0);
        System.out.println("Alugando " + object);
        System.out.println("Objetos disponiveis" + availableObjects);
        return object;
    }

    public void returnObject(T object) {
        System.out.println("Devolvendo " + object);
        availableObjects.add(object);
        System.out.println("Objetos disponiveis" + availableObjects);
    }
}

// If we need to use more than one attribute, we can. Just add another letter, like X.
class TwoAttributes<T,X> {
    private T first;
    private X second;

    public TwoAttributes(T first, X second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public X getSecond() {
        return second;
    }

    public void setSecond(X second) {
        this.second = second;
    }
}