package br.com.abc.javacore.methodsintro.test;

import br.com.abc.javacore.methodsintro.classes.Student;

public class StudentTest {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Carlos Magalhaes");
        student.setAge(-15);
        student.setScores(new double[]{7.3, 6.9, 7.4});

        student.printStudent();
        student.isApproved();
    }
}
