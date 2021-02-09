package br.com.abc.javacore.ZZJoptional.test;

import br.com.abc.javacore.ZZJoptional.classes.Car;
import br.com.abc.javacore.ZZJoptional.classes.InsuranceCompany;
import br.com.abc.javacore.ZZJoptional.classes.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalTest2 {
    public static void main(String[] args) {
        InsuranceCompany insuranceCompany = new InsuranceCompany("DevDojo Seguros");
        Car car = new Car(insuranceCompany, "audi");
        Person person = new Person(car, "Anna");
        getInsuranceCompanyName(Optional.ofNullable(person));
        checkInsuranceCompanyName(insuranceCompany);
        checkInsuranceCompanyNameOptional(insuranceCompany);
        person.setAge(20);
        System.out.println(getInsuranceCompanyNameWithAge(person, 18));

        Map<String, String> map = new HashMap<>();
        System.out.println(Optional.ofNullable(map.get("kaka")));
        stringToInt("A");
    }

    private static Optional<Integer> stringToInt(String number) {
        try {
            return Optional.of(Integer.parseInt(number));
        } catch (NumberFormatException e) {
//            e.printStackTrace();
            return Optional.empty();
        }
    }

    private static void checkInsuranceCompanyName(InsuranceCompany insuranceCompany) {
        if (insuranceCompany != null && insuranceCompany.getName().equals("DevDojo Seguros")) {
            System.out.println("eh o DevDojo");
        }
    }

    private static void checkInsuranceCompanyNameOptional(InsuranceCompany insuranceCompany) {
       Optional.ofNullable(insuranceCompany)
                .filter(iC -> iC.getName().equals("DevDojo Seguros"))
                .ifPresent(x -> System.out.println("eh o DevDojo"));
    }

    private static String getInsuranceCompanyNameWithAge(Person person, int minimumAge) {
        return Optional.ofNullable(person)
                .filter(p -> person.getAge() >= minimumAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsuranceCompany)
                .map(InsuranceCompany::getName)
                .orElse("Nao existe seguradora ou a idade minima nao foi atingida");
    }

    public static String getInsuranceCompanyName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                     .flatMap(Car::getInsuranceCompany)
                     .map(InsuranceCompany::getName)
                     .orElse("Nao existe essa seguradora");
    }
}
