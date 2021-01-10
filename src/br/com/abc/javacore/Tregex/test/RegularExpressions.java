package br.com.abc.javacore.Tregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {
    public static void main(String[] args) {
/*        \d - everything that is a digit
          \D - everything that isn't a digit
          \s - blank spaces
          \S - blank spaces - everything that is in danger.
          \w - letter and digits = everything that is a world character (a-z, A-Z, digits and _)
          \W - letter and digits = everything that isn't a world character (a-z, A-Z, digits and _)
 */
        String regex = "\\w";
        String text = "aba423434           2baba ";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        System.out.println("texto:  "+text);
        System.out.println("indice: 0123456789");
        System.out.println("expressao: "+matcher.pattern());
        System.out.println("posicoes encontradas");
        while (matcher.find()) {
            System.out.print(matcher.start()+" ");
        }
    }
}
