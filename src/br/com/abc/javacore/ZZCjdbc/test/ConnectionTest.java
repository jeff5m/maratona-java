package br.com.abc.javacore.ZZCjdbc.test;

import br.com.abc.javacore.ZZCjdbc.classes.Buyer;
import br.com.abc.javacore.ZZCjdbc.db.BuyerDB;

import java.util.List;

public class ConnectionTest {
    public static void main(String[] args) {
//        insert();
//        delete();
//        update();
//        List<Buyer> buyerList = selectAll();
//        System.out.println(buyerList);
//        List<Buyer> buyerList2 = findByName("a");
//        System.out.println(buyerList2);
//        BuyerDB.selectMetaData();
//        BuyerDB.checkDriverStatus();
        BuyerDB.cursorPointerTypeScrollTest();
    }

    public static void insert() {
        Buyer buyer = new Buyer("000.000.000-00", "Gilbert");
        BuyerDB.save(buyer);
    }

    public static void delete() {
        Buyer buyer = new Buyer();
        buyer.setId(2);
        BuyerDB.delete(buyer);
    }

    public static void update() {
        Buyer buyer = new Buyer(1, "000.000.000-11", "MARIA");
        BuyerDB.update(buyer);
    }

    public static List<Buyer> selectAll() {
        return BuyerDB.selectAll();
    }

    public static List<Buyer> findByName(String searchTerm) {
        return BuyerDB.findByName(searchTerm);
    }
}
