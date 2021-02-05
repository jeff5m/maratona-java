package br.com.abc.javacore.ZZHlambdas.test;

import br.com.abc.javacore.ZZHlambdas.classes.Car;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.*;

import static java.util.Arrays.asList;

public class LambdaTest2 {
    public static void main(String[] args) {
        forEach(asList("Lee", "world", "Developer"), (String s) -> System.out.println(s));
        List<Integer> list = map(asList("Lee", "world", "Developer"), (String s) -> s.length());
        List<String> colorsList = map(asList(new Car("grafite", 2018), new Car("vermelho", 2018)), (Car car) -> car.getColor());
        System.out.println(list);
        System.out.println(colorsList);

//        Autoboxing and Unboxing cause a small reduce in performance
//        predicate has specific interfaces to work with primitive types that are faster.
        Predicate<Integer> evens = (Integer i) -> i % 2 == 0;
        System.out.println(evens.test(1000));
        IntPredicate odds = (int i) -> i % 2 == 1;
        System.out.println(odds.test(3));
        Predicate<String> predicate = (String s) -> colorsList.add(s);
        predicate.test("AZUL");
        System.out.println(colorsList);
        Consumer<String> consumer = (s) -> colorsList.add(s);
        consumer.accept("AMARELO");
        System.out.println(colorsList);

        Supplier<String> supplier1 = () -> "oi";
        Supplier<Car> supplier2 = () -> new Car("Preto", 2019);
        System.out.println(supplier1.get());
        System.out.println(supplier2.get().getColor());
    }

//    Some important Functional Interfaces:
//    Predicate - useful to filter data
//    Consumer - useful to access an element and do some operation on it
//    Supplier - useful to return objects
    public static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T e : list) {
            consumer.accept(e);
        }
    }

//    Function - receives one type and returns another
    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T e : list) {
            result.add(function.apply(e));
        }
        return result;
    }
}
