package br.com.abc.javacore.ZZFdesignpatterns.test;

import br.com.abc.javacore.ZZFdesignpatterns.classes.Person;

public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person.PersonsBuilder("Lee")
                .lastName("Suito")
                .middleName("Kaito")
                .nickName("Coite")
                .fathersName("Kashik")
                .build();
    }
}
