package br.com.abc.javacore.OExceptions.test;

public class ErrorTest {
    public static void main(String[] args) {
        StackOverFlowError();
    }
    static void StackOverFlowError(){
        StackOverFlowError();
    }
}
