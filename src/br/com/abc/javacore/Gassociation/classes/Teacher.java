package br.com.abc.javacore.Gassociation.classes;

public class Teacher {
    private String name;
    private String specialty;
    private Seminar[] seminars;

    public Teacher() {
    }

    public Teacher(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public void print() {
        System.out.println("---------- Relatorio do professor ----------");
        System.out.println("Nome: " + this.name);
        System.out.println("Especialidade: " + this.specialty);
        if (this.seminars != null && this.seminars.length != 0) {
            System.out.println("Seminarios participantes:");
            for (Seminar seminar : this.seminars) {
                System.out.print("  " + seminar.getTitle() + " ");
            }
            return;
        }
        System.out.println("Seminarios participantes: Sem seminarios");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Seminar[] getSeminars() {
        return seminars;
    }

    public void setSeminars(Seminar[] seminars) {
        this.seminars = seminars;
    }
}
