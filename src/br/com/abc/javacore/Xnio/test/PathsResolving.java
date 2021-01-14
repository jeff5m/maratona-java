package br.com.abc.javacore.Xnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsResolving {
    public static void main(String[] args) {
        Path directory = Paths.get("home/jeff");
        Path file = Paths.get("dev/arquivo.txt");
        Path resolvingResult = directory.resolve(file);
        System.out.println(resolvingResult);

        Path absolute = Paths.get("/home/jeff");
        Path relative = Paths.get("dev");
        Path targetFile = Paths.get("file.txt");
        System.out.println("1: "+absolute.resolve(relative));
        System.out.println("2: "+absolute.resolve(targetFile));
        System.out.println("3: "+relative.resolve(targetFile));
        System.out.println("4: "+relative.resolve(absolute));
        System.out.println("5: "+targetFile.resolve(absolute));
        System.out.println("6: "+targetFile.resolve(relative));
    }
}
