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
 */
//      hexadecimal number regex
        int hexadecimalNumber = 0x100;
        String regex = "0[xX][0-9a-fA-F]";
        String text = "12 0x 0x 0xFFABC 0x10G 0x1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        System.out.println("texto:  "+text);
        System.out.println("indice: 0123456789");
        System.out.println("expressao: "+matcher.pattern());
        System.out.println("posicoes encontradas");
        while (matcher.find()) {
            System.out.println(matcher.start()+" "+matcher.group());
        }

    }
}
