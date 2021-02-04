package br.com.abc.javacore.ZZFdesignpatterns.classes;

public class CoinFactory {
    public static Coin createCoin(Country country) {
        if (country.equals(Country.BRAZIL))
            return new Real();
        else if (country.equals(Country.USA))
            return new USDollar();
        throw new IllegalArgumentException("Nao existe este pais");
    }
}
