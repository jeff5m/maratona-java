package br.com.abc.javacore.OExceptions.checkedexceptions.classes;

public class Reader2 implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("Fechando leitor 2");
    }
}
