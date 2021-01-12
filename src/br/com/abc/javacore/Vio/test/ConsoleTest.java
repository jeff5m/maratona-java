package br.com.abc.javacore.Vio.test;

import java.io.Console;

public class ConsoleTest {
    public static void main(String[] args) {
        Console c = System.console();
        char[] password = c.readPassword("%s", "password: ");
        for (char pass : password) {
            c.format("%c ", pass);
        }
        c.format("\n");
        String text;
        while (true) {
            text = c.readLine("%s", "Digite: ");
            c.format("%s", methodReturn(text));
        }
    }

    public static String methodReturn(String arg) {
        return "estrada de dados: " + arg;
    }
}
