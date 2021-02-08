package br.com.abc.javacore.ZZHlambdas.classes;

public class CarComparator {
    public static int compareByColor(Car car1, Car car2) {
        return car1.getColor().compareTo(car2.getColor());
    }

    public int compareByYear(Car car1, Car car2) {
        return ((Integer)car1.getYear()).compareTo(car2.getYear());
    }
}
