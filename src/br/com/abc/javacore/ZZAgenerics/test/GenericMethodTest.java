package br.com.abc.javacore.ZZAgenerics.test;

import java.util.ArrayList;
import java.util.List;

public class GenericMethodTest  {
    public static void main(String[] args) {
         createArray(new Dog());
    }

//    When work with generic methods we need to specifies the type of parameter before the return type. "T" is the object
//    type and "object" is the instance of type "T". T can also be any subclass of a superclass. Just add
//    "extends SomeClass".
    public static <T> void createArray(T object) {
        List<T> list = new ArrayList<>();
        list.add(object);
        System.out.println(list);
    }
}
