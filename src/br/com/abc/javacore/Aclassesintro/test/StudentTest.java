package br.com.abc.javacore.Aclassesintro.test;

import br.com.abc.javacore.Aclassesintro.classes.Student;

public class StudentTest {
    public static void main(String[] args) {
        Student lee = new Student();
        lee.name = "Lee";
        lee.registration = "1212";
        lee.age = 12;

        System.out.println(lee.name);
        System.out.println(lee.registration);
        System.out.println(lee.age);
    }
}
