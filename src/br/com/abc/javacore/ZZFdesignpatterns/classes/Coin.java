package br.com.abc.javacore.ZZFdesignpatterns.classes;

public interface Coin {
    String getSymbol();
}

class Real implements Coin {
    @Override
    public String getSymbol() {
        return "R$";
    }
}

class USDollar implements Coin {
    @Override
    public String getSymbol() {
        return "U$";
    }
}