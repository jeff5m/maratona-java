package br.com.abc.javacore.Fstaticmodifier.classes;

public class Client {
    private static int[] installments;

    {
        System.out.println("Bloco de inicializacao nao estatico");
    }

    static {
        installments = new int[100];
        System.out.println("Dentro do bloco de inicializacao static");
        for (int i = 1; i <= 100; i++) {
            installments[i - 1] = i;
        }
    }
    static {
        System.out.println("Dentro do bloco de inicializacao static 2");
    }
    static {
        System.out.println("Dentro do bloco de inicializacao static 3");
    }

    public Client() {
        System.out.println("Criando cliente");
    }

    public static int[] getInstallments() {
        return Client.installments;
    }

}
