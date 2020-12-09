package br.com.abc.javacore.classesintro.test;

import br.com.abc.javacore.classesintro.classes.Teacher;

public class TeacherTest {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.name = "Adalberto";
        teacher.registration = "hi-453";
        teacher.rg = "12.345.678-02";
        teacher.cpf = "123.456.789-10";

        Teacher teacher2 = new Teacher();
        teacher2.name = "Jotilson";
        teacher2.registration = "hi-334";
        teacher2.rg = "34.253.634-55";
        teacher2.cpf = "109.876.543-21";

        System.out.println(teacher.name);
        System.out.println(teacher.registration);
        System.out.println(teacher.rg);
        System.out.println(teacher.cpf);
        System.out.println("-------------------------------");
        System.out.println(teacher2.name);
        System.out.println(teacher2.registration);
        System.out.println(teacher2.rg);
        System.out.println(teacher2.cpf);
    }
}
