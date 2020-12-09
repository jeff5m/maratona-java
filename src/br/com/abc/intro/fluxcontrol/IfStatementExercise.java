package br.com.abc.intro.fluxcontrol;

public class IfStatementExercise {
    public static void main(String[] args) {
        double salary = 100;
        double tax = 0;
        if (salary < 1000) {
            tax = salary * 0.05;
        } else if (salary >= 1000 && salary < 2000) {
            tax = salary * 0.1;
        } else if (salary >= 2000 && salary < 4000) {
            tax = salary * 0.15;
        } else {
            tax = salary * 0.2;
        }

        System.out.println(tax);
    }
}
