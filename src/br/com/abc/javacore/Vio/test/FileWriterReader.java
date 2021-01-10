package br.com.abc.javacore.Vio.test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterReader {
    public static void main(String[] args) {
        File file = new File("Arquivo.txt");
        try (FileWriter fileWriter = new FileWriter(file, false);
             FileReader fileReader = new FileReader(file)) {
            fileWriter.write("Escrevendo uma mensagem no arquivo\nE pulando uma linha2");
            fileWriter.flush();

            char[] in = new char[500];
            int size = fileReader.read(in);
            System.out.println("tamanho " + size);
            for (char c : in) {
                System.out.print(c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            FileWriter fileWriter = new FileWriter(file, false);
//            fileWriter.write("Escrevendo uma mensagem no arquivo\nE pulando uma linha2");
//            fileWriter.flush();
//            fileWriter.close();
//
//            FileReader fileReader = new FileReader(file);
//            char[] in = new char[500];
//            int size = fileReader.read(in);
//            System.out.println("tamanho " + size);
//            for (char c : in) {
//                System.out.print(c);
//            }
//            fileReader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
