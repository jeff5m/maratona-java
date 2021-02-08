package br.com.abc.javacore.ZZHlambdas.test;

import br.com.abc.javacore.ZZHlambdas.classes.Car;
import br.com.abc.javacore.ZZHlambdas.classes.CarComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

import static java.util.Arrays.asList;

public class LambdaTest3 {
    public static void main(String[] args) {
//        Method references
        forEach(asList("Lee", "world", "Developer"), System.out::println);
        List<Car> cars = asList(new Car("Vermelho", 2018), new Car("Azul", 2020), new Car("Preto", 2011));
//        reference to a static method
        Collections.sort(cars, CarComparator::compareByColor);
        System.out.println(cars);
//        reference to an instance method of a particular object
        CarComparator carComparator = new CarComparator();
        Collections.sort(cars, carComparator::compareByYear);
        System.out.println(cars);
//        reference to an instance method of an arbitrary object of a particular type
        List<String> names = asList("Lee", "Carlos", "Anna", "Matias"); // old way
        names.sort((s1, s2) -> s1.compareTo(s2));
        names.sort(String::compareTo);
        System.out.println(names);
        Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
        Function<String, Integer> stringToInteger2 = Integer::parseInt;
        BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);
        BiPredicate<List<String>, String> contains2 = List::contains;
        System.out.println(stringToInteger2.apply("10"));
        System.out.println(contains2.test(names, "Lee"));
//        reference to a constructor
        Supplier<CarComparator> carComparator2 = CarComparator::new;
        Collections.sort(cars, carComparator2.get()::compareByYear);
        System.out.println(cars);
        BiFunction<String, Integer, Car> carBiFunction = (s,i) -> new Car(s,i);
        BiFunction<String, Integer, Car> carBiFunction2 = Car::new; // the object isn't instantiated in this line
        System.out.println(carBiFunction.apply("rosa", 1995));
        System.out.println(carBiFunction2.apply("branco", 1995)); // the object is instantiated in this line
    }

    public static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T e : list) {
            consumer.accept(e);
        }
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T e : list) {
            result.add(function.apply(e));
        }
        return result;
    }
}
