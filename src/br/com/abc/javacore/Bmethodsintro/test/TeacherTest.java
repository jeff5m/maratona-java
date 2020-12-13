package br.com.abc.javacore.Bmethodsintro.test;

import br.com.abc.javacore.Bmethodsintro.classes.Teacher;

public class TeacherTest {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.name = "Fulano da Silva";
        teacher.cpf = "123.455.777-88";
        teacher.registration = "4234";
        teacher.rg = "21.343.756-76";

        Teacher teacher2 = new Teacher();
        teacher2.name = "Santos Beltrano";
        teacher2.cpf = "455.623.798-11";
        teacher2.registration = "4521";
        teacher2.rg = "54.624.744-51";

        teacher.printData();
        teacher2.printData();
    }
}
