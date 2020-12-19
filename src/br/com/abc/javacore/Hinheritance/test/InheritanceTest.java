package br.com.abc.javacore.Hinheritance.test;

import br.com.abc.javacore.Hinheritance.classes.Address;
import br.com.abc.javacore.Hinheritance.classes.Employee;
import br.com.abc.javacore.Hinheritance.classes.Person;

public class InheritanceTest {
    public static void main(String[] args) {
//        Person person = new Person("Carlos");
        Address address = new Address();

//        person.setCpf("111.222.333-44");
        address.setStreet("rua 1");
        address.setNeighborhood("Bairro 4");
//        person.setAddress(address);
//        person.print();

        System.out.println("-------------------------------------");

        Employee employee = new Employee("Marise");

        employee.setCpf("777.888.999-10");
        employee.setSalary(4500.34);
        employee.setAddress(address);
//        employee.print();  // Employee inherits attributes and methods from Person

    }
}
