package br.com.abc.intro.breakcontinue;

public class BreakIfStatementExercise {
    public static void main(String[] args) {
        double carValue = 21000;
        for (int portions = 1; portions <= carValue; portions++) {
            double portionValue = carValue / portions;
            if (portionValue < 1000) {
                break; // stop loop iteration
            }
            System.out.println("parcela " + portions + " R$" + portionValue);
        }
    }
}


