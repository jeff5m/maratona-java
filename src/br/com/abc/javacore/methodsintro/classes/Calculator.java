package br.com.abc.javacore.methodsintro.classes;

public class Calculator {
    public void sumTwoNumbers() {
        System.out.println(5 + 5);
    }

    public void subtractTwoNumbers() {
        System.out.println(5 - 5);
    }

    public void multiplyTwoNumbers(double n1, int n2) {
        System.out.println(n1 * n2);
    }

    public double divideTwoNumbers(double n1, double n2) {
        if (n2 != 0)
            return n1 / n2;

        return 0;
    }

    public void printTwoNumbersDivided(double n1, double n2) {
        if (n2 != 0) {
            System.out.println(n1 / n2);
            return;
        }
        System.out.println("Nao eh possivel dividir por 0");
    }

    public void alterTwoNumbers(int n1, int n2) {
        n1 = 30;
        n2 = 40;
        System.out.println("alterando dois numeros");
        System.out.println("n1: " + n1);
        System.out.println("n2: " + n2);
    }
}
