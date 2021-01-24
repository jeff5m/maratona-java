package br.com.abc.javacore.ZZCjdbc.test;

import br.com.abc.javacore.ZZCjdbc.classes.Buyer;
import br.com.abc.javacore.ZZCjdbc.db.BuyerDB;

public class ConnectionTest {
    public static void main(String[] args) {
        Buyer buyer = new Buyer("111.222.333-44", "Maria");
        BuyerDB buyerDB = new BuyerDB();
        buyerDB.save(buyer);
    }
}
