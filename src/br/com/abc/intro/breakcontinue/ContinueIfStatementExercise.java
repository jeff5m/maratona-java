package br.com.abc.intro.breakcontinue;

public class ContinueIfStatementExercise {
    public static void main(String[] args) {
        double carValue = 21000;
        for (int portions = (int) carValue; portions >= 1; portions--) {
            double portionValue = carValue / portions;
            if (portionValue < 1000) {
                continue; // jumps iteration
            }
            System.out.println("parcela " + portions + " R$" + portionValue);
        }
    }
}


