package br.com.abc.javacore.Jfinalmodifier.classes;

public class Buyer {
    private String name;

    @Override
    public String toString() {
        return "BuyerDB{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
