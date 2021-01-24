package br.com.abc.javacore.ZZCjdbc.test;

import br.com.abc.javacore.ZZCjdbc.classes.Buyer;
import br.com.abc.javacore.ZZCjdbc.db.BuyerDB;

public class ConnectionTest {
    public static void main(String[] args) {
//        insert();
//        delete();
        update();
    }

    public static void insert() {
        Buyer buyer = new Buyer("111.222.333-44", "Maria");
        BuyerDB.save(buyer);
    }

    public static void delete() {
        Buyer buyer = new Buyer();
        buyer.setId(2);
        BuyerDB.delete(buyer);
    }

    public static void update() {
        Buyer buyer = new Buyer(1,"000.000.000-11","MARIA");
        BuyerDB.update(buyer);
    }
}
