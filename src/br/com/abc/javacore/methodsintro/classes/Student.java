package br.com.abc.javacore.methodsintro.classes;

public class Student {
    private String name;
    private int age;
    private double[] scores;
    private boolean approved;

    public void printStudent() {
        System.out.println("Nome: " + this.name);
        System.out.println("Idade: " + this.age + " anos");
        if (scores != null) {
            for (double score : scores) {
                System.out.print(score + " ");
            }
        }
    }

    public void calculateAverage() {
        double average = 0;
        if (this.scores == null) {
            System.out.println("Sem notas cadastradas");
            return;
        }

        for (double score : this.scores) {
            average += score;
        }
        average /= this.scores.length;
        if (average > 6) {
            this.approved = true;
            System.out.println("\nAluno(a) " + this.name + " foi aprovado(a) com media " + average);
        } else {
            this.approved = false;
            System.out.println("\nAluno(a) " + this.name + " foi reprovado(a) com media " + average);
        }
    }

//    getters and setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("idade invalida");
            return;
        }
        this.age = age;
    }

    public void setScores(double[] scores) {
        this.scores = scores;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double[] getScores() {
        return this.scores;
    }

    public boolean isApproved() {  // for boolean types, instead of get, we use is. Set remains.
        return this.approved;
    }
}
