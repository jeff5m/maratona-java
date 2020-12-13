package br.com.abc.javacore.initializationblocks.classes;

public class Client {
    private int[] installments;

    {
        installments = new int[100];
        System.out.println("Dentro do bloco de inicializacao");
        for (int i = 1; i <= 100; i++) {
            installments[i - 1] = i;
        }
    }

    public Client() {

    }

    public int[] getInstallments() {
        return installments;
    }

    public void setInstallments(int[] installments) {
        this.installments = installments;
    }
}
