package br.com.abc.javacore.Rstrings.test;

public class StringBuilderTest {
    public static void main(String[] args) {
        String s = "Frase qualquer";
        StringBuilder sb = new StringBuilder(3); // default char capacity is 16.
        sb.append("Frase qualquer");                     // When the max capacity is reached, a copy of content is
        sb.append("backend Java");                       // created at twice the size and the content is moved there

        System.out.println(sb.toString());
        System.out.println(sb.reverse());
        System.out.println(sb.reverse());
        System.out.println(sb.delete(0,2));
        System.out.println(sb.insert(2,"#"));
    }
}
