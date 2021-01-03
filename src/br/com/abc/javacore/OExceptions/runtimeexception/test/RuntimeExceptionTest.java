package br.com.abc.javacore.OExceptions.runtimeexception.test;

public class RuntimeExceptionTest {
    public static void main(String[] args) {
        Object o = null;
        int a = 10;
        int b = 0;
        if (b != 0) {
            System.out.println(a/b);
        }

        int[] arr = new int[2];

        System.out.println(arr[2]);
        System.out.println(o.toString());
    }
}
