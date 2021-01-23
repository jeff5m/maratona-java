package br.com.abc.javacore.ZZAgenerics.test;

import java.util.ArrayList;
import java.util.List;

public class GenericMethodTest {
    public static void main(String[] args) {
         List<Dog> dogList = new ArrayList<>(createArray(new Dog()));
        System.out.println(dogList);
    }

//    When work with generic methods we need to specifies the type of parameter before the return type. "T" is the object
//    type and "object" is the instance of type "T".
    public static <T> List<T> createArray(T object) {
        List<T> list = new ArrayList<>();
        list.add(object);
        return list;
    }
}
