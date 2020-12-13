package br.com.abc.javacore.Dconstructorsoverloading.test;

import br.com.abc.javacore.Dconstructorsoverloading.classes.Student;

public class StudentTest {
    public static void main(String[] args) {
        Student student = new Student("1a", "Carlos Menezes", new double[]{4, 5, 6}, "01/10/2000");
        Student student2 = new Student();

        student.print();
    }
}
