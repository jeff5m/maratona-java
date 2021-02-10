package br.com.abc.javacore.ZZKstreams.test;

import br.com.abc.javacore.ZZKstreams.classes.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
//        old way
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
//        Streams
        List<String> names2 = persons
                .stream()
                .filter(p -> p.getAge() < 25)
                .sorted(Comparator.comparing(Person::getName))
                .limit(3)
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println(names2);
    }
}
