package br.com.abc.javacore.ZZGparameterbehaviours.test;

import br.com.abc.javacore.ZZGparameterbehaviours.classes.Car;
import br.com.abc.javacore.ZZGparameterbehaviours.interfaces.CarPredicate;
import br.com.abc.javacore.ZZGparameterbehaviours.predicate.GreenColorCarsPredicate;
import br.com.abc.javacore.ZZGparameterbehaviours.predicate.TenYearsOldCarsPredicate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Arrays.asList;

public class CarTest {
    private static List<Car> filterGreenCars(List<Car> cars) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor().equals("verde"))
                result.add(car);
        }
        return result;
    }

    private static List<Car> filterRedCars(List<Car> cars) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor().equals("vermelho"))
                result.add(car);
        }
        return result;
    }

    private static List<Car> filterCarsOlderThenTenYears(List<Car> cars) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.getYear() > Calendar.getInstance().get(Calendar.YEAR) - 10)
                result.add(car);
        }
        return result;
    }

    public static List<Car> filterCars(List<Car> cars, CarPredicate carPredicate) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (carPredicate.test(car)) {
                result.add(car);
            }
        }
        return result;
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (predicate.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Car> cars = asList(new Car("verde", 2015), new Car("vermelho", 1995), new Car("preto", 2017));
        List<Integer> numbers = asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        System.out.println(filterGreenCars(cars));
//        System.out.println(filterRedCars(cars));
//        System.out.println(filterCarsOlderThenTenYears(cars));
        System.out.println(filterCars(cars, new GreenColorCarsPredicate()));
        System.out.println(filterCars(cars, new CarPredicate() {
            @Override
            public boolean test(Car car) {
                return car.getColor().equals("verde");
            }
        }));
        System.out.println(filter(cars, new Predicate<Car>() {
            @Override
            public boolean test(Car car) {
                return car.getColor().equals("verde");
            }
        }));
        System.out.println(filter(numbers, new Predicate<Integer>() {
            @Override
            public boolean test(Integer n) {
                return n % 2 == 0;
            }
        }));
    }
}
