package br.com.abc.javacore.Xnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class PosixFileAttributesTest {
    public static void main(String[] args) {
        Path path = Paths.get("folder2/file.txt");
        try {
            if(!Files.exists(path))
                Files.createFile(path);
            PosixFileAttributes posix = Files.readAttributes(path, PosixFileAttributes.class);
            System.out.println(posix.permissions());
            System.out.println("-------------------------");
            Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("rw-rw-rw-");
            Files.setPosixFilePermissions(path, permissions);
            posix = Files.readAttributes(path, PosixFileAttributes.class);
            System.out.println(posix.permissions());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
