package br.com.abc.javacore.ZZKstreams.test;

import br.com.abc.javacore.ZZKstreams.classes.Person;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.summarizingDouble;
import static java.util.stream.Collectors.summingDouble;

public class StreamTest6Collectors1 {
    public static void main(String[] args) {
        List<Person> person = Person.personDataBase();
//        count
        System.out.println(person.stream().count());
        System.out.println(person.stream().collect(counting()));

//        get max or min value
        Optional<Person> max = person.stream().max(comparing(Person::getSalary));
        System.out.println(max.get().getSalary());
        Optional<Person> collect = person.stream().collect(maxBy(comparing(Person::getSalary)));
        System.out.println(collect.get().getSalary());
        Optional<Person> collectMin = person.stream().collect(minBy(comparing(Person::getSalary)));
        System.out.println(collectMin.get().getSalary());

//        sum
        System.out.println(person.stream().mapToDouble(Person::getSalary).sum());
        System.out.println(person.stream().collect(summingDouble(Person::getSalary)));

//        average
        System.out.println(person.stream().mapToDouble(Person::getSalary).average());
        System.out.println(person.stream().collect(averagingDouble(Person::getSalary)));

//        get the sum, count, min, max and average values
        DoubleSummaryStatistics doubleSummaryStatistics = person.stream().collect(summarizingDouble((Person::getSalary)));
        System.out.println(doubleSummaryStatistics);
        System.out.println(doubleSummaryStatistics.getAverage());

//        concatenate strings
        System.out.println(person.stream().map(Person::getName).collect(joining(", ")));
    }
}
