package br.com.abc.javacore.OExceptions.checkedexceptions.test;

import br.com.abc.javacore.OExceptions.customexceptions.InvalidLoginException;

public class CustomExceptionTest {
    public static void main(String[] args) {
        try {
            logIn();
        } catch (InvalidLoginException e) {
            e.printStackTrace();
        }
    }

    private static void logIn() throws InvalidLoginException {
        String DBUser = "admin";
        String DBPassword = "admin";
        String typedUser = "admin";
        String typedPassword = "12345";
        if (!DBUser.equals(typedUser) || !DBPassword.equals(typedPassword)) {
            throw new InvalidLoginException();
        } else {
            System.out.println("Usuario logado com sucesso!");
        }
    }
}
