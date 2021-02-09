package br.com.abc.javacore.ZZJoptional.classes;

import java.util.Optional;

public class Person {
    private Car car;
    private String name;
    private int age;

    public Person(Car car, String name) {
        this.car = car;
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    public Optional<Car> getCar() {
        return Optional.ofNullable(car);
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
