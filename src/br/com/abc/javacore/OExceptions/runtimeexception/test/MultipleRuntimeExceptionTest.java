package br.com.abc.javacore.OExceptions.runtimeexception.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class MultipleRuntimeExceptionTest {
    public static void main(String[] args) {
        try {
            throw new IndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Dentro de ArrayIndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Dentro de IndexOutOfBoundsException");
        } catch (IllegalArgumentException exception) {
            System.out.println("Dentro de IllegalArgumentException");
        } catch (ArithmeticException exception) {
            System.out.println("Dentro de ArithmeticException");
        }
        System.out.println("final do programa");

        try {
            maybeThrowAnException();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void maybeThrowAnException() throws SQLException, FileNotFoundException {

    }
}
