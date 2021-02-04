package br.com.abc.javacore.ZZFdesignpatterns.test;

import br.com.abc.javacore.ZZFdesignpatterns.classes.SingletonPlane;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonPlaneTest {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        scheduleSeat("1A");
        scheduleSeat("1A");

        SingletonPlane singletonPlane = SingletonPlane.getINSTANCE();
        SingletonPlane singletonPlane2 = null;
        Constructor[] constructors = SingletonPlane.class.getDeclaredConstructors();
        for(Constructor constructor : constructors) {
            constructor.setAccessible(true);
            singletonPlane2 = (SingletonPlane) constructor.newInstance();
            break;
        }
        System.out.println(singletonPlane.hashCode());
        System.out.println(singletonPlane2.hashCode());
    }

    private static void scheduleSeat(String seat) {
        SingletonPlane plane = SingletonPlane.getINSTANCE();
        System.out.println(plane.bookSeat(seat));
    }
}
