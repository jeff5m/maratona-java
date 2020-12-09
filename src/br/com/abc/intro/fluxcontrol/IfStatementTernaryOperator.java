package br.com.abc.intro.fluxcontrol;

public class IfStatementTernaryOperator {
    public static void main(String[] args) {
        int age = 15;

//        if (age < 18) {
//            System.out.println("nao adulto");
//        } else {
//            System.out.println("adulto");
//        }

        String status = age < 18 ? "nao adulto" : "adulto"; // preciso atribuir a uma variavel, a nao ser que coloque direto em um print

        System.out.println(age < 18 ? "nao adulto" : "adulto");

    }
}
