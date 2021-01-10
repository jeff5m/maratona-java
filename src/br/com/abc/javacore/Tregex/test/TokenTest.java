package br.com.abc.javacore.Tregex.test;

public class TokenTest {
    public static void main(String[] args) {
//        tokens with String
        String str = "Lee, Carlos, Anna, Marcos, John, Maria, Carla";
        String[] tokens = str.split(",");
        for(String token : tokens) {
            System.out.println(token.trim());
        }
    }
}
