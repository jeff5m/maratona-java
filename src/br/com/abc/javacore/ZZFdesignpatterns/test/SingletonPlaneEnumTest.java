package br.com.abc.javacore.ZZFdesignpatterns.test;

import br.com.abc.javacore.ZZFdesignpatterns.classes.SingletonPlaneEnum;

public class SingletonPlaneEnumTest {
    public static void main(String[] args) {
        SingletonPlaneEnum.scheduleSeat("1A");
        SingletonPlaneEnum.scheduleSeat("1A");
    }
}
