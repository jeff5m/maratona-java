package br.com.abc.javacore.Fstaticmodifier.test;

import br.com.abc.javacore.Fstaticmodifier.classes.Client;

public class ClientTest {
    public static void main(String[] args) {
        Client cli1 = new Client();
        Client cli2 = new Client();
        Client cli3 = new Client();
        System.out.println("Exibindo a quantidade de parcelas disponiveis");

        for (int installment : Client.getInstallments()) {
            System.out.print(installment + " ");
        }

        System.out.println("tamanho: " + Client.getInstallments().length);
    }
}
