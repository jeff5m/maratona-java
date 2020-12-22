package br.com.abc.javacore.Kenum.classes;

public class Client {
    public enum PaymentType {
        AVISTA, APRAZO
    }
    private String name;
    private ClientType clientType;
    private PaymentType paymentType;

    public Client(String name, ClientType clientType, PaymentType paymentType) {
        this.name = name;
        this.clientType = clientType;
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return "Nome: " + this.name + " | Tipo de cliente: " + clientType.getName() + " - numero: " + clientType.getType() + " | Tipo de pagamento: " + this.paymentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClientType getTypeClient() {
        return clientType;
    }

    public void setTypeClient(ClientType clientType) {
        this.clientType = clientType;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
