package br.com.abc.javacore.ZZFdesignpatterns.test;

import br.com.abc.javacore.ZZFdesignpatterns.classes.Plane;

public class PlaneTest {
    public static void main(String[] args) {
        scheduleSeat("1A");
        scheduleSeat("1A");
    }

    private static void scheduleSeat(String seat) {
        Plane plane = new Plane();
        System.out.println(plane.seatsBook(seat));
    }
}
