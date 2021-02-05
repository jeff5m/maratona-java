package br.com.abc.javacore.ZZHlambdas.interfaces;

import br.com.abc.javacore.ZZHlambdas.classes.Car;

@FunctionalInterface
public interface CarPredicate {
//    function descriptor - determinate how our lambda will be declared
    boolean test(Car car);
}
