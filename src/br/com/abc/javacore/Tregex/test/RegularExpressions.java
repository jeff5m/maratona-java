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
          [] - select specific characters marked inside the square brackets
          ? - zero or one
          * - zero or more
          + - one or more
          {n,m} - select instances of character by how much they cab pay.\
          () - group a expression together
          | - add or comparison
          $ - end line
          . - joker, can replace anything
*/

//      hexadecimal number regex
//        int hexadecimalNumber = 0x1;
//        String regex = "0[xX]([0-9a-fA-F])+(\\s|$)";
//        String text = "12 0x 0x 0x01FFABC 0x10G 0x1";
        String regex = "([\\w\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";
        String text = "fulano@gmail.com, cicla-no@hotmail.com, 12345@email, asdf@gmail.com, test@outlook.com.br";
        System.out.println("Email valido? "+"$#@validationtest@mail".matches(regex));
        printRegex(text, regex);

//      DATES
//        String regexDate = "\\d\\d/\\d\\d/\\d\\d\\d\\d";
        String regexDate = "\\d{2}/\\d{2}/\\d{2,4}";
        String textDate = "05/10/2010 05/05/2015 1/1/01 01/05/95";
        printRegex(textDate, regexDate);
    }

    private static void printRegex(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        System.out.println("texto:  "+text);
        System.out.println("indice: 0123456789");
        System.out.println("expressao: "+matcher.pattern());
        System.out.println("posicoes encontradas");
        while (matcher.find()) {
            System.out.println(matcher.start()+" "+matcher.group());
        }
        System.out.println("--------------------------------------------");
    }
}
