package br.com.abc.javacore.ZZIdefault.interfaces;

public interface B {
    default void hi() {
        System.out.println("Dentro do oi de B");
    }
}
