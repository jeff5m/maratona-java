package br.com.abc.javacore.ZZAgenerics.test;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class Animal {
    public abstract void consult();
}

class Dog extends Animal implements Comparable {
    @Override
    public void consult() {
        System.out.println("Consultando Cachorro");
    }

    @Override
    public int compareTo(@NotNull Object o) {
        return 0;
    }
}

class Cat extends Animal {
    @Override
    public void consult() {
        System.out.println("Consultando Gato");
    }
}

public class WildCardTest {
    public static void main(String[] args) {
        Dog[] dogs = {new Dog(), new Dog()};
        Cat[] cats = {new Cat(), new Cat()};
//        consultAnimals(dogs);
//        consultAnimals(cats);
//        With regard methods parameters, arrays can use polymorphism directly.
        Animal[] animals = {new Cat(), new Dog()};
        Animal[] animals2 = new Dog[5];
        System.out.println("--------------------------");

//        When work with collections, we need to pass exactly the same type to the methods. The method consultAnimalsList
//        will only accept a List of Animal as argument. We can do consultAnimalsList(dogsList) or consultAnimalsList(catsList).
//        But inside the method, we can add subclasses from Animal.
//        There is a way to pass a subclass to a List argument, using the wild character "?". At the method parameters
//        we use "List<? extends Animal> animals". But, since we don't know specifically what will be the type of object
//        received by the method, we can not add items to that list inside that method.
        List<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog());
        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat());
        consultAnimalsList(dogList);
        consultAnimalsList(catList);
        sortList(dogList);
    }

//    Animal is a superclass of Dog and Cat, so we can put those arrays into an Animals array. This way this method
//    can be used for any subclasses from Animal.  JVM knows exactly which are the types of the array in runtime. This
//    prevents us to try to store the wrong type of object, like animals[1] = new Cat(). Do that would throw an
//    ArrayStoreException.
    public static void consultAnimals(Animal[] animals) {
        for (Animal animal : animals) {
            animal.consult();
        }
    }

    public static void consultAnimalsList(List<? extends Animal> animals) {
        for (Animal animal : animals) {
            animal.consult();
        }
    }

//    In this method, we can pass a List of Dog or a type Animal, super class of Dog
    public static void consultDogsList(List<? super Dog> dogList) {
        Dog dog1 = new Dog();
        Animal dog2 = new Dog();
        Object obj = new Dog();
        dogList.add(dog1);
    }
//    Doesn't matter if is a Interface or a Class, the is always extends. In this case, we only accept list of classes
//    that implements Comparable.
    public static void sortList(List<? extends Comparable> list) {
        Collections.sort(list);
    }
}
