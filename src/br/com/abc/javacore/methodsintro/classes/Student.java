package br.com.abc.javacore.methodsintro.classes;

public class Student {
    public String name;
    public int age;
    public double[] scores;

    public void printStudent() {
        System.out.println("Nome: " + this.name);
        System.out.println("Idade: " + this.age + " anos");
        if (scores != null) {
            for (double score : scores) {
                System.out.print(score + " ");
            }
        }
    }

    public void isApproved() {
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
            System.out.println("\nAluno(a) " + this.name + " foi aprovado(a) com media " + average);
        } else {
            System.out.println("\nAluno(a) " + this.name + " foi reprovado(a) com media " + average);
        }
    }
}
