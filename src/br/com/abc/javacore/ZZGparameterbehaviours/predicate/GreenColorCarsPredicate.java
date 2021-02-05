package br.com.abc.javacore.ZZGparameterbehaviours.predicate;

import br.com.abc.javacore.ZZGparameterbehaviours.classes.Car;
import br.com.abc.javacore.ZZGparameterbehaviours.interfaces.CarPredicate;

public class GreenColorCarsPredicate implements CarPredicate {
    @Override
    public boolean test(Car car) {
        return car.getColor().equals("verde");
    }
}
