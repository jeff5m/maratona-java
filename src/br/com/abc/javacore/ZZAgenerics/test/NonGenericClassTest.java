package br.com.abc.javacore.ZZAgenerics.test;

import br.com.abc.javacore.ZZAgenerics.classes.Car;
import br.com.abc.javacore.ZZAgenerics.classes.Computer;

import java.util.ArrayList;
import java.util.List;

public class NonGenericClassTest {
    public static void main(String[] args) {
        RentableCar rentableCar = new RentableCar();
        Car rentedCar = rentableCar.getAvailableCar();
        System.out.println("Carro usado por um mes");
        rentableCar.returnCar(rentedCar);
        System.out.println("Carro devolvido");

        System.out.println("-------------------------------");

        RentableComputer rentableComputer = new RentableComputer();
        Computer rentedComputer = rentableComputer.getAvailableComputer();
        System.out.println("Computador usado por um mes");
        rentableComputer.returnComputer(rentedComputer);
        System.out.println("Computador devolvido");
    }
}

class RentableCar {
    private List<Car> availableCars = new ArrayList<>();

    {
        availableCars.add(new Car("BMW"));
        availableCars.add(new Car("Volvo"));
    }

    public Car getAvailableCar() {
        Car car = availableCars.remove(0);
        System.out.println("Alugando carro: " + car);
        System.out.println("Carros disponiveis" + availableCars);
        return car;
    }

    public void returnCar(Car car) {
        System.out.println("Devolvendo carro: " + car);
        availableCars.add(car);
        System.out.println("Carros disponiveis" + availableCars);
    }
}

class RentableComputer {
    private List<Computer> availableComputers = new ArrayList<>();

    {
        availableComputers.add(new Computer("System76"));
        availableComputers.add(new Computer("Dell"));
    }

    public Computer getAvailableComputer() {
        Computer computer = availableComputers.remove(0);
        System.out.println("Alugando computador: " + computer);
        System.out.println("Computadores disponiveis" + availableComputers);
        return computer;
    }

    public void returnComputer(Computer computer) {
        System.out.println("Devolvendo computador: " + computer);
        availableComputers.add(computer);
        System.out.println("Computadores disponiveis" + availableComputers);
    }
}
