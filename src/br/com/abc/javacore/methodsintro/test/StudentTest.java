package br.com.abc.javacore.methodsintro.test;

import br.com.abc.javacore.methodsintro.classes.Student;

public class StudentTest {
    public static void main(String[] args) {
        Student student = new Student();
        student.name = "Carlos Magalhaes";
        student.age = 15;
        student.scores = new double[]{7.3, 6.9, 7.4};

        student.printStudent();
        student.isApproved();

    }
}
