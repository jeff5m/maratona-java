package br.com.abc.javacore.ZZKstreams.test;

import br.com.abc.javacore.ZZKstreams.classes.Person;

import java.util.Comparator;
import java.util.List;

public class StreamTest3 {
    public static void main(String[] args) {
        List<Person> person = Person.personDataBase();
        System.out.println(person.stream().anyMatch(p -> p.getSalary() > 4000));
        System.out.println(person.stream().allMatch(p -> p.getAge() > 18));
        System.out.println(person.stream().noneMatch(p -> p.getAge() < 18));
        person.stream()
                .filter(p -> p.getAge() < 90)
                .findAny()
                .ifPresent(p -> System.out.println(p.getName()));

        person.stream()
                .filter(p -> p.getAge() > 25)
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .findFirst()
                .ifPresent(p -> System.out.println(p.getName()));
    }
}
