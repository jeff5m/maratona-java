package br.com.abc.javacore.initializationblocks.test;

import br.com.abc.javacore.initializationblocks.classes.Client;

public class ClientTest {
    public static void main(String[] args) {
        Client cli = new Client();
        System.out.println("Exibindo a quantidade de parcelas disponiveis");
        for (int installment : cli.getInstallments()){
            System.out.print(installment+" ");
        }
    }
}
