package br.com.abc.javacore.ZZHlambdas.test;

import br.com.abc.javacore.ZZHlambdas.classes.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.util.Arrays.asList;

public class LambdaTest2 {
    public static void main(String[] args) {
        forEach(asList("Lee", "world", "Developer"), (String s) -> System.out.println(s));
        List<Integer> list = map(asList("Lee", "world", "Developer"), (String s) -> s.length());
        List<String> colorsList = map(asList(new Car("grafite", 2018), new Car("vermelho", 2018)), (Car car) -> car.getColor());
        System.out.println(list);
        System.out.println(colorsList);
    }

//    Some important Functional Interfaces:
//    Predicate - useful to filter data
//    Consumer - useful to access an element and do some operation on it
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
