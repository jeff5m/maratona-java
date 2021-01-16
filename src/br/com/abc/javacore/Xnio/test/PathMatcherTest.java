package br.com.abc.javacore.Xnio.test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class FindAllTestFiles extends SimpleFileVisitor<Path> {
    private PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*{Test*}.{java,class}");
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(matcher.matches(file)) {
            System.out.println(file.getFileName());
        }
        return FileVisitResult.CONTINUE;
    }
}

public class PathMatcherTest {
    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("folder/subfolder/subsubfolder/file.bkp");
        Path path2 = Paths.get("file.bkp");
        Path path3 = Paths.get("jeff-lee");
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.bkp");
        System.out.println(matcher.matches(path1));
        System.out.println(matcher.matches(path2));
        System.out.println("--------------------------------");
        matches(path1, "glob:*.bkp");
        matches(path1, "glob:**/*.bkp"); // will consider any thing, any where in the given path
        matches(path1, "glob:*.bkp");
        matches(path1, "glob:**");
        System.out.println("--------------------------------");
        matches(path3, "glob:{jeff*,lee*}");
        matches(path3, "glob:{jeff,lee}*");
        matches(path3, "glob:{jeff,lee}");
        Files.walkFileTree(Paths.get("./"), new FindAllTestFiles());
    }

    private static void matches(Path path, String glob) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println(glob + ": " + matcher.matches(path));
    }
}
