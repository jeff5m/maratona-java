package br.com.abc.javacore.Rstrings.test;

public class StringTest {
    public static void main(String[] args) {
        String name = "Antonio";
        name.concat(" Alberto");
//        String doesn't change
        System.out.println(name);
//        concatenated string
        name = name.concat(" Alberto");
        System.out.println(name);
    }
}
