package br.com.abc.javacore.Ioverrides.test;

import br.com.abc.javacore.Ioverrides.classes.Person;

public class PersonTest {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Ana Fulana");
        person.setAge(45);
        System.out.println(person);

        Person person2 = new Person();
        person2.setName("Carl Sd");
        person2.setAge(23);
        System.out.println(person2);
    }
}
