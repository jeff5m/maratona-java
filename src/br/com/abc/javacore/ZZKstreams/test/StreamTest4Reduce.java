package br.com.abc.javacore.ZZKstreams.test;

import br.com.abc.javacore.ZZKstreams.classes.Person;

import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class StreamTest4Reduce {
    public static void main(String[] args) {
        Optional<Integer> reduce = getStream().reduce((x, y) -> x + y);
        System.out.println(reduce.get());

        Integer sum = getStream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);

        Optional<Integer> sum2 = getStream().reduce(Integer::sum);
        System.out.println(sum2.get());

        Integer multiplication = getStream().reduce(1, (x, y) -> x * y);
        System.out.println(multiplication);

//        get max value
        Optional<Integer> max = getStream().reduce((x, y) -> x > y ? x : y);
        System.out.println(max.get());

        Optional<Integer> max2 = getStream().reduce(Integer::max); // or min
        System.out.println(max2.get());

        Stream<Person> personStream = Person.personDataBase().stream();
        Optional<Double> salarySum = personStream.filter(p -> p.getSalary() > 2000).map(Person::getSalary).reduce(Double::sum);
        System.out.println(salarySum.get());
        
//        Specialized primitive streams
        Stream<Person> personStream2 = Person.personDataBase().stream();
        double doubleSum =
                personStream2
                .filter(p -> p.getSalary() > 2000)
                .mapToDouble(Person::getSalary).sum();
        System.out.println(doubleSum);

        DoubleStream doubleStream = Person.personDataBase()
                .stream()
                .filter(p -> p.getSalary() > 2000)
                .mapToDouble(Person::getSalary);
//        returns a stream again
        Stream<Double> boxed = doubleStream.boxed();
    }

    private static Stream<Integer> getStream() {
        return asList(1, 2, 3, 4, 5, 6).stream();
    }
}
