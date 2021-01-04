package br.com.abc.javacore.OExceptions.checkedexceptions.test;

import br.com.abc.javacore.OExceptions.checkedexceptions.classes.Reader1;
import br.com.abc.javacore.OExceptions.checkedexceptions.classes.Reader2;

import java.io.*;

public class TryWithResourcesTest {
    public static void main(String[] args) {
        readFile();
    }

    public static void readFileOldWay() {
        Reader reader = null;
        try {
            reader = new BufferedReader(new FileReader("text.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readFile() {
//        Code inside () must implement closeable or autocloseable interfaces
//        To read a file the code is "Reader reader = new BufferedReader(new FileReader("text.txt"))"
//        Files are closed in the reverse order in which they are opened
        try (Reader1 reader1 = new Reader1();
             Reader2 reader2 = new Reader2()) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
