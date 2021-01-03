package br.com.abc.javacore.OExceptions.checkedexceptions.test;

import java.io.File;
import java.io.IOException;

public class CheckedExceptionTest {
    public static void main(String[] args) {
        openFile();
    }

    public static void createFile() throws IOException {
        File file = new File("test.txt");
        try {
            System.out.println("Arquivo criado? "+file.createNewFile());
            System.out.println("Arquivo criado");
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static String openFile() {
        try {
            System.out.println("Abrindo um arquivo");
            System.out.println("Executando a leitura do aquivo");
//            throw new Exception();
            System.out.println("Escrevendo alguma coisa no aquivo");
            return "value";
        } catch (Exception e) {
            System.out.println("Dentro do catch");
            e.printStackTrace();
        } finally {
            System.out.println("Fechando o arquivo");
        }
        return null;
    }
}
