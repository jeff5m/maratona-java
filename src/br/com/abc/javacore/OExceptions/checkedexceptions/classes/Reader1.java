package br.com.abc.javacore.OExceptions.checkedexceptions.classes;

public class Reader1 implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("Fechando leitor 1");
    }
}
