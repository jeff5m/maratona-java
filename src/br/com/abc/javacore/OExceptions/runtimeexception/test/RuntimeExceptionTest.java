package br.com.abc.javacore.OExceptions.runtimeexception.test;

public class RuntimeExceptionTest {
    public static void main(String[] args) {

        try {
            division(10,0);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    private static void division(int n1, int n2) {
        if (n2 == 0) {
            throw new IllegalArgumentException("Passe um valor diferente de 0");
        }
        int result = n1/n2;
        System.out.println(result);
    }
}
