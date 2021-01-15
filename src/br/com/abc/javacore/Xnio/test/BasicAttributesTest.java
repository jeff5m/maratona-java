package br.com.abc.javacore.Xnio.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BasicAttributesTest {
    public static void main(String[] args) throws IOException {
        Date decemberFirst = new GregorianCalendar(2015, Calendar.DECEMBER, 1).getTime();
        File file = new File("folder2/renamed_file.txt");
        file.createNewFile();
        file.setLastModified(decemberFirst.getTime());
        System.out.println(file.lastModified());
        file.delete();

        Path filesPath = Paths.get("folder2/path_file.txt");
        Files.createFile(filesPath);
        FileTime fileTime = FileTime.fromMillis(decemberFirst.getTime());
        Files.setLastModifiedTime(filesPath, fileTime);
        System.out.println(Files.getLastModifiedTime(filesPath));
        Files.deleteIfExists(filesPath);

        filesPath = Paths.get("src/br/com/abc/javacore/Aclassesintro/classes/Car.java");
        System.out.println(Files.isReadable(filesPath));
        System.out.println(Files.isWritable(filesPath));
        System.out.println(Files.isExecutable(filesPath));
//        Interfaces to deal with files in NIO in only read mode
//        BasicFilesAttributes - basic attributes to all OS
//        PosixFileAttributes - attributes to unix based systems
//        DosFileAttributes - attributes windows based systems

        BasicFileAttributes basicFileAttributes = Files.readAttributes(filesPath, BasicFileAttributes.class);
        System.out.println("create " + basicFileAttributes.creationTime());
        System.out.println("last access " + basicFileAttributes.lastAccessTime());
        System.out.println("last modified " + basicFileAttributes.lastModifiedTime());
//        System.out.println(basicFileAttributes.isDirectory());
//        System.out.println(basicFileAttributes.isSymbolicLink());
//        System.out.println(basicFileAttributes.isRegularFile());
        System.out.println("---------------------------------------------");

//        Interfaces to deal with files in NIO and change data
//        BasicFilesAttributeView - basic attributes to all OS
//        PosixFileAttributeView - attributes to unix based systems
//        DosFileAttributeView - attributes windows based systems
//        FileOwnerAttributeView - used to set the file or directory ownership
//        AclFileAttributeView - provides more advanced permissions to work in teh files or directories

        FileTime lastModified = basicFileAttributes.lastModifiedTime();
        FileTime created = basicFileAttributes.creationTime();
        FileTime lastAccess = FileTime.fromMillis(System.currentTimeMillis());
        BasicFileAttributeView basicFileAttributeView = Files.getFileAttributeView(filesPath, BasicFileAttributeView.class);
        basicFileAttributeView.setTimes(lastModified, lastAccess, created);
        basicFileAttributes = Files.readAttributes(filesPath, BasicFileAttributes.class);
        System.out.println("create " + basicFileAttributes.creationTime());
        System.out.println("last access " + basicFileAttributes.lastAccessTime());
        System.out.println("last modified " + basicFileAttributes.lastModifiedTime());

    }
}
