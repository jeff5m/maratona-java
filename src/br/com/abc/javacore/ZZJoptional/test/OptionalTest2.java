package br.com.abc.javacore.ZZJoptional.test;

import br.com.abc.javacore.ZZJoptional.classes.Car;
import br.com.abc.javacore.ZZJoptional.classes.InsuranceCompany;
import br.com.abc.javacore.ZZJoptional.classes.Person;

import java.util.Optional;

public class OptionalTest2 {
    public static void main(String[] args) {
        InsuranceCompany insuranceCompany = new InsuranceCompany("DevDojo Seguros");
        Car car = new Car(null, "audi");
        Person person = new Person(car, "Anna");
        getInsuranceCompanyName(Optional.ofNullable(person));
    }

    public static String getInsuranceCompanyName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                     .flatMap(Car::getInsuranceCompany)
                     .map(InsuranceCompany::getName)
                     .orElse("Nao existe essa seguradora");
    }
}
