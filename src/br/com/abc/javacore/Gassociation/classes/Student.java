package br.com.abc.javacore.Gassociation.classes;

public class Student {
    private String name;
    private int age;
    private Seminar seminar;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void print() {
        System.out.println("---------- Relatorio do alunos ----------");
        System.out.println("Nome: " + this.name);
        System.out.println("Idade: " + this.age);
        if (this.seminar != null)
            System.out.println("Seminario inscrito: " + this.seminar.getTitle());
        else
            System.out.println("Nenhum seminario inscrito");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Seminar getSeminar() {
        return seminar;
    }

    public void setSeminar(Seminar seminar) {
        this.seminar = seminar;
    }
}
