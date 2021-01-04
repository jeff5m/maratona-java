package br.com.abc.javacore.OExceptions.customexceptions;

public class InvalidLoginException extends Exception {
    public InvalidLoginException() {
        super("Usuario ou senha invalidos");
    }
}
