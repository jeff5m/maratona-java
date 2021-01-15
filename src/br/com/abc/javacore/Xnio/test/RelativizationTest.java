package br.com.abc.javacore.Xnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativizationTest {
    public static void main(String[] args) {
        Path directory = Paths.get("/home/jeff");
        Path classes = Paths.get("/home/jeff/java/Person.java");
        Path pathToClass = directory.relativize(classes);
        System.out.println(pathToClass);

        Path absolute1 = Paths.get("/home/jeff");
        Path absolute2 = Paths.get("/usr/local");
        Path absolute3 = Paths.get("/home/jeff/java/Person.java");
        Path relative1 = Paths.get("temp");
        Path relative2 = Paths.get("temp/Employee.java");
        System.out.println("1: " + absolute1.relativize(absolute3));
        System.out.println("2: " + absolute3.relativize(absolute1));
        System.out.println("3: " + absolute1.relativize(absolute2));
        System.out.println("4: " + relative1.relativize(relative2));
        System.out.println("5: " + absolute1.relativize(relative1));
    }
}
