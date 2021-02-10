package br.com.abc.javacore.ZZKstreams.classes;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

public class Person {
    private String name;
    private int age;
    private double salary;

    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public static List<Person> personDataBase() {
        return asList(
                new Person("Lee", 22, 1800),
                new Person("Jeff", 24, 900),
                new Person("Martinez", 24, 3000),
                new Person("Maria", 20, 2100),
                new Person("Maria", 20, 2100),
                new Person("Carlita", 27, 2600),
                new Person("Anna", 23, 5000),
                new Person("Carlos", 48, 2000),
                new Person("Jorge", 29, 1900)
        );
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
