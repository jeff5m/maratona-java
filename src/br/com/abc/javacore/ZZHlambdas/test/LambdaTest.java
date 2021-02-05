
package br.com.abc.javacore.ZZHlambdas.test;

import br.com.abc.javacore.ZZHlambdas.classes.Car;
import br.com.abc.javacore.ZZHlambdas.interfaces.CarPredicate;

import java.util.function.Predicate;

public class LambdaTest {
    //        anonymous
//        function
//        can be passed as argument to a method or attributed to a reference variable
//        concise
//        (Car car) -> car.getColor().equals("verde");
//        (String s) -> s.length()
//        (int a, int b) -> {System.out.println(a+b)}
//        lambdas can only be used with Functional Interfaces - the one that has only one method. But it can have more
//          then one if "default" is used. This mean that the implementation is not required.
//        the method signature in the interface dictates the lambda body
    public static void main(String[] args) {
        CarPredicate carPredicate = new CarPredicate() {
            @Override
            public boolean test(Car car) {
                return car.getColor().equals("verde");
            }
        };
        Predicate<Car> carPredicateLambda = (Car car) -> car.getColor().equals("verde");
        System.out.println(carPredicate.test(new Car("verde", 2019)));
        System.out.println(carPredicateLambda.test(new Car("verde", 2019)));
        Runnable runnable = () -> System.out.println("Dentro do run");
        new Thread(runnable).start();
    }
}
