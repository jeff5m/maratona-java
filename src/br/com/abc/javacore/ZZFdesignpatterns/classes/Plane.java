package br.com.abc.javacore.ZZFdesignpatterns.classes;

import java.util.HashSet;
import java.util.Set;

public class Plane {
    private Set<String> availableSeats;

    public Plane() {
        this.availableSeats = new HashSet<>();
        availableSeats.add("1A");
        availableSeats.add("1D");
    }

    public boolean seatsBook(String seat) {
        return availableSeats.remove(seat);
    }
}
