package br.com.abc.javacore.Vio.test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileTest {
    public static void main(String[] args) {
        File file = new File("Arquivo.txt");
        try {
            System.out.println(file.createNewFile());
            System.out.println("Arquivo tem permissao de leitura? " + file.canRead());
            System.out.println("Caminho: " + file.getPath());
            System.out.println("Caminho completo: " + file.getAbsolutePath());
            System.out.println("Diretorio? " + file.isDirectory());
            System.out.println("Oculto? " + file.isHidden());
            System.out.println("Ultima modificacao? " + new Date(file.lastModified()));

            boolean exists = file.exists();
            if (exists) {
                System.out.println("Deletado? " + file.delete());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
