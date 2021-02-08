package br.com.abc.javacore.ZZJoptional.test;

import java.util.Optional;

public class OptionalTest1 {
    String name;
    public static void main(String[] args) {
        OptionalTest1 optionalTest = new OptionalTest1();
        Optional<String> optional1 = Optional.of("DevDojo");
        Optional<String> optional2 = Optional.empty();
        Optional<String> optional3 = Optional.ofNullable(optionalTest.name);
        System.out.println(optional1);
        System.out.println(optional2);
        System.out.println(optional3);
//        get values
        System.out.println(optional1.get());
        if (optional2.isPresent())
            System.out.println(optional2.get());
        System.out.println(optional3.orElse("vazio"));
    }
}
