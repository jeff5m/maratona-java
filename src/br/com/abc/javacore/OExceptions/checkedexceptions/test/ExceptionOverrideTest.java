package br.com.abc.javacore.OExceptions.checkedexceptions.test;

import br.com.abc.javacore.OExceptions.checkedexceptions.classes.Employee;
import br.com.abc.javacore.OExceptions.checkedexceptions.classes.Person;
import br.com.abc.javacore.OExceptions.customexceptions.InvalidLoginException;

import java.io.FileNotFoundException;

public class ExceptionOverrideTest {
    public static void main(String[] args) {
        Employee employee = new Employee();
        Person person = new Person();

        try {
            employee.save();
        } catch (InvalidLoginException e) {
            e.printStackTrace();
        }

    }
}
