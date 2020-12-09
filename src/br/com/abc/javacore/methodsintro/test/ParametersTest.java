package br.com.abc.javacore.methodsintro.test;

import br.com.abc.javacore.methodsintro.classes.Calculator;

public class ParametersTest {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int n1 = 5;
        int n2 = 10;
        calc.alterTwoNumbers(n1, n2);
        System.out.println("dentro do teste");
        System.out.println("n1: " + n1);
        System.out.println("n2: " + n2);
    }
}
