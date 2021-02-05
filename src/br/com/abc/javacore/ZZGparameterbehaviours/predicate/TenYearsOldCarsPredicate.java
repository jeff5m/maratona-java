package br.com.abc.javacore.ZZGparameterbehaviours.predicate;

import br.com.abc.javacore.ZZGparameterbehaviours.classes.Car;
import br.com.abc.javacore.ZZGparameterbehaviours.interfaces.CarPredicate;

import java.util.Calendar;

public class TenYearsOldCarsPredicate implements CarPredicate {
    @Override
    public boolean test(Car car) {
        return car.getYear() > Calendar.getInstance().get(Calendar.YEAR) - 10;
    }
}
