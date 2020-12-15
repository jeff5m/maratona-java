package br.com.abc.javacore.Gassociation.test;

import br.com.abc.javacore.Gassociation.classes.Local;
import br.com.abc.javacore.Gassociation.classes.Seminar;
import br.com.abc.javacore.Gassociation.classes.Student;
import br.com.abc.javacore.Gassociation.classes.Teacher;

public class AssociationTest {
    public static void main(String[] args) {
        Student student1 = new Student("Lee", 54);
        Student student2 = new Student("Kenobi", 32);
        Seminar seminar = new Seminar("Como ser um Dev pro");
        Teacher teacher = new Teacher("Carlos Marques", "Software Engineering");
        Local local = new Local("Rua qwerty", "Asdf");

        student1.setSeminar(seminar);
        student2.setSeminar(seminar);

        seminar.setTeacher(teacher);
        seminar.setLocal(local);
        seminar.setStudents(new Student[]{student1, student2});

        Seminar[] seminarsArr = new Seminar[1];
        seminarsArr[0] = seminar;
        teacher.setSeminars(seminarsArr);

        seminar.print();
        teacher.print();
    }
}
