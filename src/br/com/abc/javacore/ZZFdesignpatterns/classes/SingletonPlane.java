package br.com.abc.javacore.ZZFdesignpatterns.classes;

import java.util.HashSet;
import java.util.Set;

public class SingletonPlane {
    //    EAGER INITIALIZATION - this object will always be instantiated because it is static
//    private static final SingletonPlane INSTANCE = new SingletonPlane();
//    LAZY INITIALIZATION - this object will only be instantiated if we needed.
    private static SingletonPlane INSTANCE;
    private Set<String> availableSeats;

    public static SingletonPlane getINSTANCE() {
//        double check makes this a thread safe method.
        if (INSTANCE == null) {
            synchronized (SingletonPlane.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonPlane();
                }
            }
        }
        return INSTANCE;
    }

    private SingletonPlane() {
        this.availableSeats = new HashSet<>();
        availableSeats.add("1A");
        availableSeats.add("1D");
    }

    public boolean bookSeat(String seat) {
        return availableSeats.remove(seat);
    }
}
