package br.com.abc.javacore.ZZFdesignpatterns.test;

import br.com.abc.javacore.ZZFdesignpatterns.classes.Coin;
import br.com.abc.javacore.ZZFdesignpatterns.classes.CoinFactory;
import br.com.abc.javacore.ZZFdesignpatterns.classes.Country;

public class CoinFactoryTest {
    public static void main(String[] args) {
        Coin coin = CoinFactory.createCoin(Country.USA);
        System.out.println(coin.getSymbol());
    }
}
