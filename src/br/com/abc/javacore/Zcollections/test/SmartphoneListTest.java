package br.com.abc.javacore.Zcollections.test;

import br.com.abc.javacore.Zcollections.classes.Smartphone;

import java.util.ArrayList;
import java.util.List;

public class SmartphoneListTest {
    public static void main(String[] args) {
        Smartphone smartphone1 = new Smartphone("Galaxy S7","1234");
        Smartphone smartphone2 = new Smartphone("iPhone","5678");
        Smartphone smartphone3 = new Smartphone("Moto Z","91011");

        List<Smartphone> smartphoneList = new ArrayList<>();
        smartphoneList.add(smartphone1);
        smartphoneList.add(smartphone2);
        smartphoneList.add(smartphone3);

        for (Smartphone smartphone : smartphoneList){
            System.out.println(smartphone);
        }
        System.out.println();

        Smartphone smartphone4 = new Smartphone("Galaxy S7", "1234");
        System.out.println(smartphone1.equals(smartphone4));
        System.out.println(smartphoneList.contains(smartphone4)); // this method returns true because the .equal() implementation uses the IMEI value
    }
}
