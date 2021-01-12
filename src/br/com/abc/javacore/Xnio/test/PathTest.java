package br.com.abc.javacore.Xnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
    public static void main(String[] args) {
//        /home/jeff5m/IdeaProjects/JavaOnline
        Path p1 = Paths.get("/home/jeff5m/IdeaProjects/JavaOnline/Arquivo.txt");
        Path p2 = Paths.get("/home/jeff5m/IdeaProjects/JavaOnline", "Arquivo.txt");
        Path p3 = Paths.get("/", "home/jeff5m/IdeaProjects/JavaOnline", "Arquivo.txt");
        Path p4 = Paths.get("/", "home", "jeff5m", "IdeaProjects", "JavaOnline", "Arquivo.txt");
        System.out.println(p1.toAbsolutePath());
        System.out.println(p2.toAbsolutePath());
        System.out.println(p3.toAbsolutePath());
        System.out.println(p4.toAbsolutePath());
    }
}
