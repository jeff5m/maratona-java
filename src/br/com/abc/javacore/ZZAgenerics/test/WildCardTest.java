package br.com.abc.javacore.ZZAgenerics.test;

import java.util.ArrayList;
import java.util.List;

abstract class Animal {
    public abstract void consult();
}

class Dog extends Animal {
    @Override
    public void consult() {
        System.out.println("Consultando Cachorro");
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
        Dog[] dogs = {new Dog(),new Dog()};
        Cat[] cats = {new Cat(), new Cat()};
        consultAnimals(dogs);
        consultAnimals(cats);
//        Arrays can use polymorphism directly.
        Animal[] animals = {new Cat(), new Dog()};
        Animal[] animals2 = new Dog[5];
        System.out.println("--------------------------");

//        When work with collections, we need to pass exactly the same type to the methods. The method consultAnimalsList
//        will only accept a List of Animal as argument. We can do consultAnimalsList(dogsList) or consultAnimalsList(catsList).
//        But inside the method, we can add subclasses from Animal.
        List<Dog> dogList = new ArrayList<>();
        dogList.add(new Dog());
        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat());
//        consultAnimalsList(dogList);
//        consultAnimalsList(catList);

        List<Animal> animalList = new ArrayList<>();
        consultAnimalsList(animalList);
        System.out.println(animalList.size());
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
    public static void consultAnimalsList (List<Animal> animals) {
        for (Animal animal : animals) {
            animal.consult();
        }
        animals.add(new Dog());
        animals.add(new Cat());
    }
}
