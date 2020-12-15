package br.com.abc.javacore.Gassociation.classes;

public class Local {
    private String street;
    private String neighborhood;

    public Local() {
    }

    public Local(String street, String neighborhood) {
        this.street = street;
        this.neighborhood = neighborhood;
    }

    public void print(){
        System.out.println("---------- Informacoes do local ----------");
        System.out.println("Rua: "+this.street);
        System.out.println("Bairro: "+this.neighborhood);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
}
