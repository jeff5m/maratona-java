package br.com.abc.javacore.Gassociation.classes;

public class Seminar {
    private String title;
    private Teacher teacher;
    private Student[] students;
    private Local local;

    public Seminar() {
    }

    public Seminar(String title) {
        this.title = title;
    }

    public void print() {
        System.out.println("---------- Relatorio do seminario ----------");
        System.out.println("Titulo: " + this.title);
        if (this.teacher != null)
            System.out.println("Professor: " + this.teacher.getName());
        else
            System.out.println("Professor: Sem professor palestrante");
        if (this.local != null)
            System.out.println("Local: Rua " + this.local.getStreet() + ", bairro: " + this.local.getNeighborhood());
        else
            System.out.println("Local: Sem local definido");
        if (this.students != null && this.students.length != 0) {
            System.out.println("Estudantes inscritos:");
            for (Student student : this.students) {
                System.out.println(" " + student.getName() + " ");
            }
            return;
        }
        System.out.println("Estudantes inscritos: Sem estudantes inscritos");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
}
