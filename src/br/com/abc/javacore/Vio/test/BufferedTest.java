package br.com.abc.javacore.Vio.test;

import java.io.*;

public class BufferedTest {
    public static void main(String[] args) {
        File file = new File("ArquivoBuffered.txt");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
             BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            bufferedWriter.write("Escrevendo uma mensagem no arquivo");
            bufferedWriter.newLine();
            bufferedWriter.write("Pulando uma linha");
            bufferedWriter.flush();

            String str;
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try {
//            FileWriter fileWriter = new FileWriter(file);
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            bufferedWriter.write("Escrevendo uma mensagem no arquivo");
//            bufferedWriter.newLine();
//            bufferedWriter.write("Pulando uma linha");
//            bufferedWriter.flush();
//            bufferedWriter.close();
//
//            FileReader fileReader = new FileReader(file);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String str = null;
//            while ((str = bufferedReader.readLine()) != null) {
//                System.out.println(str);
//            }
//            bufferedReader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
