package br.com.abc.javacore.ZZFdesignpatterns.classes;

import java.util.HashSet;
import java.util.Set;

public enum SingletonPlaneEnum {
    INSTANCE;
    private Set<String> availableSeats;

    SingletonPlaneEnum() {
        this.availableSeats = new HashSet<>();
        availableSeats.add("1A");
        availableSeats.add("1D");
    }

    public boolean bookSeat(String seat) {
        return availableSeats.remove(seat);
    }

    public static void scheduleSeat(String seat) {
        SingletonPlaneEnum plane = SingletonPlaneEnum.INSTANCE;
        System.out.println(plane.bookSeat(seat));
    }
}
