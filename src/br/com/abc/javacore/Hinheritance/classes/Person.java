package br.com.abc.javacore.Hinheritance.classes;

public class Person {
    protected String name;
    protected String cpf;
    protected Address address;

    public void print() {
        System.out.println("Nome: " + this.name);
        System.out.println("CPF: " + this.cpf);
        if (this.address != null)
            System.out.println("Endereco: " + this.address.getStreet() + ", " + "bairro: " + this.address.getNeighborhood());
        else
            System.out.println("Endereco nao encontrado");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
