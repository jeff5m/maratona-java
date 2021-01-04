package br.com.abc.javacore.Passertions.test;

public class Assertions {
    public static void main(String[] args) {
        calculateSalary(-2000);
    }

    private static void calculateSalary(double salary) {
//        is also possible throw a message:
//          assert (<assertion>) : "<message>"
        assert (salary > 0) : "Salario deve ser maior que 0. O valor recebido foi: " + salary;
        System.out.println(salary + 0.55);
    }

    //    if the verification is in a public method, throw an exception is a better choice
    public static void calcSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException();
        }
    }

}
