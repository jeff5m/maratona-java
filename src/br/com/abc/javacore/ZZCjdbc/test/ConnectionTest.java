package br.com.abc.javacore.ZZCjdbc.test;

import br.com.abc.javacore.ZZCjdbc.classes.Buyer;
import br.com.abc.javacore.ZZCjdbc.db.BuyerDB_StudyReference;

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
//        BuyerDB_StudyReference.selectMetaData();
//        BuyerDB_StudyReference.checkDriverStatus();
//        BuyerDB_StudyReference.cursorPointerTypeScrollTest();
//        BuyerDB_StudyReference.updateNamesToLowerCase();
//        System.out.println(BuyerDB_StudyReference.findByNamePreparedStatement("onh"));
//        System.out.println(BuyerDB_StudyReference.findByNameCallableStatement("thew"));
//        System.out.println(BuyerDB_StudyReference.findByNameRowSet("thew"));
//        BuyerDB_StudyReference.updateCachedRowSet(new Buyer(6,"123.456.789-12", "Maike"));
        try {
            BuyerDB_StudyReference.saveTransaction();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insert() {
        Buyer buyer = new Buyer("000.000.000-00", "Gilbert");
        BuyerDB_StudyReference.save(buyer);
    }

    public static void delete() {
        Buyer buyer = new Buyer();
        buyer.setId(2);
        BuyerDB_StudyReference.delete(buyer);
    }

    public static void update() {
        Buyer buyer = new Buyer(1, "111.000.000-11", "MARIA");
//        BuyerDB_StudyReference.update(buyer);
        BuyerDB_StudyReference.updatePreparedStatement(buyer);
    }

    public static List<Buyer> selectAll() {
        return BuyerDB_StudyReference.selectAll();
    }

    public static List<Buyer> findByName(String searchTerm) {
        return BuyerDB_StudyReference.findByName(searchTerm);
    }
}
