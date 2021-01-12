package br.com.abc.javacore.Vio.test;

import java.io.File;
import java.io.IOException;

public class FileDirectoryTest {
    public static void main(String[] args) throws IOException {
//        File directory = new File("folder");
//        System.out.println("Diretorio criado? " + directory.mkdir());
//
//        File file = new File(directory, "file.txt");
//        System.out.println("Arquivo criado? " + file.createNewFile());
//
//        File newFileName = new File(directory, "renamed_file.txt");
//        System.out.println("Arquivo renomeado? " + file.renameTo(newFileName));
//
//        File renamedDirectory = new File("folder2");
//        System.out.println("Diretorio renomeado? "+directory.renameTo(renamedDirectory));

        fileSearch();
    }

    public static void fileSearch() {
        File file = new File("/home/jeff5m/IdeaProjects/JavaOnline");
        String[] filesList = file.list();
        for (String fileName : filesList) {
            System.out.println(fileName);
        }
    }
}
