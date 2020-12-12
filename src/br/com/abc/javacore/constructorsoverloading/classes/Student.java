package br.com.abc.javacore.constructorsoverloading.classes;

public class Student {
    private String registration;
    private String name;
    private double[] scores;
    private String registrationDate;

    public Student(String registration, String name, double[] scores) {
        this.registration = registration;
        this.name = name;
        this.scores = scores;
    }

    public Student(String registration, String name, double[] scores, String registrationDate) {
        this(registration, name, scores);
        this.registrationDate = registrationDate;
    }
    
    public Student() {

    }

    public void print() {
        System.out.println("matricula: " + this.registration);
        System.out.println("nome: " + this.name);
        System.out.println("notas: ");
        for(double score : scores) {
            System.out.print(score + "  ");
        }
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double[] getScores() {
        return scores;
    }

    public void setScores(double[] scores) {
        this.scores = scores;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
}
