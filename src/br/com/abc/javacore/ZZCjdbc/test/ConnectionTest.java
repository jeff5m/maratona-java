package br.com.abc.javacore.ZZCjdbc.test;

import br.com.abc.javacore.ZZCjdbc.classes.Buyer;
import br.com.abc.javacore.ZZCjdbc.db.BuyerDB;

import java.sql.SQLException;
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
//        BuyerDB.cursorPointerTypeScrollTest();
//        BuyerDB.updateNamesToLowerCase();
//        System.out.println(BuyerDB.findByNamePreparedStatement("onh"));
//        System.out.println(BuyerDB.findByNameCallableStatement("thew"));
//        System.out.println(BuyerDB.findByNameRowSet("thew"));
//        BuyerDB.updateCachedRowSet(new Buyer(6,"123.456.789-12", "Maike"));
        try {
            BuyerDB.saveTransaction();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        Buyer buyer = new Buyer(1, "111.000.000-11", "MARIA");
//        BuyerDB.update(buyer);
        BuyerDB.updatePreparedStatement(buyer);
    }

    public static List<Buyer> selectAll() {
        return BuyerDB.selectAll();
    }

    public static List<Buyer> findByName(String searchTerm) {
        return BuyerDB.findByName(searchTerm);
    }
}
