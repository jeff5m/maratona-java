package br.com.abc.javacore.Tregex.test;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("1 true 100 hi");
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
        System.out.println("------------------------------");
        Scanner scanner2 = new Scanner("1 true 100 hi");
        while (scanner2.hasNext()) {
            if (scanner2.hasNextInt()) {
                int i = scanner2.nextInt();
                System.out.println("int" + i);
            } else if (scanner2.hasNextBoolean()) {
                boolean bool = scanner2.nextBoolean();
                System.out.println(bool);
            } else {
                System.out.println(scanner2.next());
            }
        }
    }
}
