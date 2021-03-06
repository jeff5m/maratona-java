package br.com.abc.javacore.ZZCjdbc.test;

import br.com.abc.javacore.ZZCjdbc.classes.Buyer;
import br.com.abc.javacore.ZZCjdbc.db.BuyerDAO;

import java.util.List;
import java.util.Scanner;

public class BuyerCRUD {
    private static Scanner input = new Scanner(System.in);

    public static void execute(int op) {
        switch (op) {
            case 1:
                insert();
                break;
            case 2:
                update();
                break;
            case 3:
                list();
                break;
            case 4:
                System.out.println("Digite o nome ou parte do nome do Comprador: ");
                searchByName(input.nextLine());
                break;
            case 5:
                delete();
                break;
            default:
                System.out.println("Saindo do sistema...");
                CRUDTest.setLogin(false);
                break;
        }
    }

    private static void insert() {
        Buyer buyer = new Buyer();
        System.out.println("Nome: ");
        buyer.setName(input.nextLine());
        System.out.println("CPF: ");
        buyer.setCpf(input.nextLine());
        BuyerDAO.save(buyer);
        System.out.println();
    }

    private static void update() {
        System.out.println("Selecione o numero de um dos Compradores abaixo:");
        List<Buyer> buyerList = list();
        Buyer buyer = buyerList.get(Integer.parseInt(input.nextLine()));
        System.out.println("Novo nome ou enter para manter o atual");
        String name = input.nextLine();
        System.out.println("Novo cpf ou enter para manter o atual");
        String cpf = input.nextLine();
        if (!name.isEmpty()) {
            buyer.setName(name);
        }
        if (!cpf.isEmpty()) {
            buyer.setCpf(cpf);
        }
        BuyerDAO.update(buyer);
        System.out.println();
    }

    protected static List<Buyer> list() {
        List<Buyer> buyerList = BuyerDAO.selectAll();
        for (int i = 0; i < buyerList.size(); i++) {
            Buyer buyer = buyerList.get(i);
            System.out.println("[" + i + "] " + buyer.getName() + " " + buyer.getCpf());
        }
        System.out.println();
        return buyerList;
    }

    private static void searchByName(String searchTerm) {
        List<Buyer> buyerLIst = BuyerDAO.searchByName(searchTerm);
        for (int i = 0; i < buyerLIst.size(); i++) {
            Buyer buyer = buyerLIst.get(i);
            System.out.println("[" + i + "] " + buyer.getName() + " " + buyer.getCpf());
        }
        System.out.println();
    }

    private static void delete() {
        System.out.println("Selecione um dos compradores abaixo para deletar: ");
        List<Buyer> buyerList = list();
        Buyer buyer = buyerList.get(Integer.parseInt(input.nextLine()));
        System.out.println(buyer.getName() + " " + buyer.getCpf());
        System.out.println("Tem certeza? Digite y para confirmar...");
        String confimation = input.nextLine();
        if (confimation.equalsIgnoreCase("y") || confimation.isEmpty())
            BuyerDAO.delete(buyer);
        else
            System.out.println("Comprador nao deletado");

        System.out.println();
    }
}
