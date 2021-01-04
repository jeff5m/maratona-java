package br.com.abc.javacore.OExceptions.runtimeexception.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class MultipleRuntimeExceptionTest {
    public static void main(String[] args) {
        try {
            throw new IndexOutOfBoundsException();
        } catch (IllegalArgumentException | IndexOutOfBoundsException | ArithmeticException exception) {
            System.out.println("Dentro de ArrayIndexOutOfBoundsException");
        }
        System.out.println("final do programa");

        try {
            maybeThrowAnException();
        } catch (SQLException | IOException e) {

        }
    }

    private static void maybeThrowAnException() throws SQLException, IOException {

    }
}
