package br.com.abc.javacore.ZZCjdbc.test;

import java.util.Scanner;

public class CRUDTest {
    private static Scanner input = new Scanner(System.in);
    private static boolean login = true;
    public static void setLogin(boolean login) {
        CRUDTest.login = login;
    }

    public static void main(String[] args) {
        int op;
        while (login) {
            menu();
            op = Integer.parseInt(input.nextLine()); // make the system do not read enter as a character
            if (op == 0) {
                System.out.println("Saindo do sistema...");
                break;
            }
            if (op == 1) {
                buyerMenu();
                op = Integer.parseInt(input.nextLine());
                BuyerCRUD.execute(op);
            }
            if (op == 2) {
                carMenu();
                op = Integer.parseInt(input.nextLine());
                CarCRUD.execute(op);
            }
        }
    }

    private static void menu() {
        System.out.println("Selecionae uma opção:");
        System.out.println("1. Comparador");
        System.out.println("2. Carro");
        System.out.println("0. Sair");
    }

    private static void buyerMenu() {
        System.out.println("Digite a opção para começar:");
        System.out.println("1. Inserir Comprador");
        System.out.println("2. Atualizar Comprador");
        System.out.println("3. Listar todos os Compradores");
        System.out.println("4. Buscar Comprador por nome");
        System.out.println("5. Deletar Comprador");
        System.out.println("9. Voltar");
    }
    private static void carMenu() {
        System.out.println("Digite a opção para começar:");
        System.out.println("1. Inserir Carro");
        System.out.println("2. Atualizar Carro");
        System.out.println("3. Listar todos os Carros");
        System.out.println("4. Buscar Carro por nome");
        System.out.println("5. Deletar Carro");
        System.out.println("9. Voltar");
    }
}
