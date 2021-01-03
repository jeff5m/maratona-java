package br.com.abc.javacore.OExceptions.error.test;

public class ErrorTest {
    public static void main(String[] args) {
        StackOverFlowError();
    }
    static void StackOverFlowError(){
        StackOverFlowError();
    }
}
