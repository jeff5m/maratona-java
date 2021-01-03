package br.com.abc.javacore.OExceptions.checkedexceptions.test;

import java.io.File;
import java.io.IOException;

public class CheckedExceptionTest {
    public static void main(String[] args) {
        createFile();
    }

    public static void createFile() {
        File file = new File("test.txt");
        try {
            System.out.println("Arquivo criado? "+file.createNewFile());
            System.out.println("Arquivo criado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
