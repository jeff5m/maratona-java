package br.com.abc.javacore.Xnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NormalizationTest {
    public static void main(String[] args) {
        String directoryFolder = "JavaOnline/home/jeff/dev";
        String txtFile = "../../arquivo.txt";

        Path p1 = Paths.get(directoryFolder, txtFile);
        System.out.println(p1);
        System.out.println(p1.normalize());

        Path p2 = Paths.get("home/./jeff/./dev");
        System.out.println(p2);
        System.out.println(p2.normalize());
    }
}
