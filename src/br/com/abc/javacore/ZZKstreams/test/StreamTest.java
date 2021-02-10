package br.com.abc.javacore.ZZKstreams.test;

import br.com.abc.javacore.ZZKstreams.classes.Person;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
//        Collections - store the data
        List<Person> persons = Person.personDataBase();
        Collections.sort(persons, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        List<String> names = new ArrayList<>();
        for (Person person : persons) {
            if (person.getAge() < 25) {
                names.add(person.getName());
                if (names.size() >= 3) {
                    break;
                }
            }
        }
        System.out.println(names);
//        Streams - compute the data. Streams has two types of operations:
//        Intermediate - return another stream. Those operations will only be executed when a terminal operation be invoked.
//        The stream chaining is the Lazing kind. Been so, this operations can be merged in one step be Terminal operation.
//        Terminal - return another type of value that is not a stream, like a List<> or a String.
        List<String> names2 = persons
                .stream()
                .filter(p -> p.getAge() < 25)
                .sorted(Comparator.comparing(Person::getName))
                .limit(3)
                .skip(1) // pass the n result returned by the operation
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println(names2);
        System.out.println(persons
                .stream()
                .distinct()
                .filter(p -> p.getAge() < 25)
                .map(Person::getName)
                .count());

        persons.stream().forEach(System.out::println);
    }
}
