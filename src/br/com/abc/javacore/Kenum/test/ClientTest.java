package br.com.abc.javacore.Kenum.test;

import br.com.abc.javacore.Kenum.classes.Client;
import br.com.abc.javacore.Kenum.classes.ClientType;

public class ClientTest {
    public static void main(String[] args) {
        Client client1 = new Client("Sara Mercel", ClientType.PESSOA_JURIDICA, Client.PaymentType.AVISTA);
        System.out.println(client1);
        System.out.println(ClientType.PESSOA_FISICA.getId());
        System.out.println(ClientType.PESSOA_JURIDICA.getId());
    }
}
