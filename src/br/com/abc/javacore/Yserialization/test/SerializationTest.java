package br.com.abc.javacore.Yserialization.test;

import br.com.abc.javacore.Yserialization.classes.SchoolClass;
import br.com.abc.javacore.Yserialization.classes.Student;

import java.io.*;

public class SerializationTest {
    public static void main(String[] args) {
        objectRecorder();
        objectReader();
    }

    private static void objectRecorder() {
        Student student = new Student(1L, "Jeff Lee", "123456", new SchoolClass("maratona-java_1"));
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("aluno.serializado"))) {
            objectOutputStream.writeObject(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void objectReader() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("aluno.serializado"))) {
//            the object constructor is not call. This directly impact Inheritance.
            Student student = (Student) objectInputStream.readObject();
            System.out.println(student);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
