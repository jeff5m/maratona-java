package br.com.abc.javacore.methodsintro.test;

import br.com.abc.javacore.methodsintro.classes.Calculator;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.sumTwoNumbers();
        calc.subtractTwoNumbers();
        calc.multiplyTwoNumbers(3.5, 6);
        System.out.println("realizando a divisao de dois numeros:");
        double result = calc.divideTwoNumbers(3,0);
        System.out.println(result);
        System.out.println("-----------------");
        System.out.println("imprimindo a divisao de dois numeros");
        calc.printTwoNumbersDivided(20,0);
    }
}
