package br.com.abc.javacore.ZZKstreams.classes;

import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

public class Person {
    private String name;
    private int age;
    private double salary;
    private Gender gender;

    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Person(String name, int age, double salary, Gender gender) {
        this(name, age, salary);
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
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
                new Person("Lee", 22, 1800, Gender.MASCULINO),
                new Person("Jeff", 24, 900, Gender.MASCULINO),
                new Person("Martinez", 24, 3000, Gender.FEMININO),
                new Person("Maria", 20, 2100, Gender.FEMININO),
                new Person("Maria", 20, 2100, Gender.FEMININO),
                new Person("Carlita", 27, 2600, Gender.FEMININO),
                new Person("Anna", 17, 5000, Gender.FEMININO),
                new Person("Carlos", 48, 2000, Gender.MASCULINO),
                new Person("Jorge", 16, 1900, Gender.MASCULINO)
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

    public Gender getGender() {
        return gender;
    }
}
