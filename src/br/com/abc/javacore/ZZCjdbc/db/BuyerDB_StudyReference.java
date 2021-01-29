package br.com.abc.javacore.ZZCjdbc.db;

import br.com.abc.javacore.ZZCjdbc.classes.Buyer;
import br.com.abc.javacore.ZZCjdbc.classes.MyRowSetListener;
import br.com.abc.javacore.ZZCjdbc.conn.ConnectionFactory;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BuyerDB_StudyReference {
    public static void save(Buyer buyer) {
        String sql = "INSERT INTO `maratona_java`.`buyer` (`cpf`, `name`) VALUES ('" + buyer.getCpf() + "', '" + buyer.getName() + "');";
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stat = conn.createStatement();
//            if the query update state of the DB, use .executeUpdate();
//            if we are retrieving data from the DB, .executeQuery();
            stat.executeUpdate(sql);
            ConnectionFactory.close(conn, stat);
            System.out.println("Registro inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveTransaction() throws SQLException {
        String sql = "INSERT INTO maratona_java.buyer (cpf, name) VALUES ('TEST1', 'TEST1')";
        String sql2 = "INSERT INTO maratona_java.buyer (cpf, name) VALUES ('TEST2', 'TEST2')";
        String sql3 = "INSERT INTO maratona_java.buyer (cpf, name) VALUES ('TEST3', 'TEST3')";
        Connection conn = ConnectionFactory.getConnection();
        Savepoint savepoint = null;
        try {
            conn.setAutoCommit(false);
            Statement stat = conn.createStatement();
            stat.executeUpdate(sql);
            savepoint = conn.setSavepoint("One");
//           makes savepoint available again
            conn.releaseSavepoint(savepoint);
            stat.executeUpdate(sql2);
            if(true)
                throw new SQLException();
            stat.executeUpdate(sql3);
            conn.commit();
            ConnectionFactory.close(conn, stat);
            System.out.println("Registro tipo Transaction inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
//             if transaction fails, this method rollbacks DB to the previous state or, if a savepoint is passed as argument,
//            to the point attributed to that savepoint. In that case we must commit the connection.
            conn.rollback(savepoint);
            conn.commit();
        }
    }

    public static void delete(Buyer buyer) {
        if (buyer == null || buyer.getId() == null) {
            System.out.println("Ops! Não foi possível excluir o registro!");
            return;
        }

        String sql = "DELETE FROM `maratona_java`.`buyer` WHERE (`id` = '" + buyer.getId() + "');";
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stat = conn.createStatement();
            stat.executeUpdate(sql);
            ConnectionFactory.close(conn, stat);
            System.out.println("Registro excluido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Buyer buyer) {
        if (buyer == null || buyer.getId() == null) {
            System.out.println("Ops! Não foi possível atualizar o registro!");
            return;
        }

        String sql = "UPDATE `maratona_java`.`buyer` SET `cpf` = '" + buyer.getCpf() + "', `name` = '" + buyer.getName() + "' WHERE (`id` = '" + buyer.getId() + "')";
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stat = conn.createStatement();
            stat.executeUpdate(sql);
            ConnectionFactory.close(conn, stat);
            System.out.println("Regisitro atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePreparedStatement(Buyer buyer) {
        if (buyer == null || buyer.getId() == null) {
            System.out.println("Ops! Não foi possível atualizar o registro!");
            return;
        }

        String sql = "UPDATE `maratona_java`.`buyer` SET `cpf` = ?, `name` = ? WHERE `id` = ?";
        Connection conn = ConnectionFactory.getConnection();
        try {
            PreparedStatement prepStat = conn.prepareStatement(sql);
            prepStat.setString(1, buyer.getCpf());
            prepStat.setString(2, buyer.getName());
            prepStat.setInt(3, buyer.getId());
            prepStat.executeUpdate();
            ConnectionFactory.close(conn, prepStat);
            System.out.println("Registro atualizado com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void updateRowSet(Buyer buyer) {
        if (buyer == null || buyer.getId() == null) {
            System.out.println("Ops! Não foi possível atualizar o registro!");
            return;
        }

//        String sql = "UPDATE `maratona_java`.`buyer` SET `cpf` = ?, `name` = ? WHERE `id` = ?";
        String sql = "SELECT * FROM `maratona_java`.`buyer` WHERE id = ?";
        JdbcRowSet jdbcRowSet = ConnectionFactory.getRowSetConnection();
        jdbcRowSet.addRowSetListener(new MyRowSetListener());
        try {
            jdbcRowSet.setCommand(sql);
//            jdbcRowSet.setString(1, buyer.getCpf());
//            jdbcRowSet.setString(2, buyer.getName());
            jdbcRowSet.setInt(1, buyer.getId());
            jdbcRowSet.execute();
            jdbcRowSet.next();
            jdbcRowSet.updateString("name", buyer.getName());
            jdbcRowSet.updateRow();
            ConnectionFactory.close(jdbcRowSet);
            System.out.println("Registro atualizado com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateCachedRowSet(Buyer buyer) {
        if (buyer == null || buyer.getId() == null) {
            System.out.println("Ops! Não foi possível atualizar o registro!");
            return;
        }

        String sql = "SELECT * FROM buyer WHERE `id` = ?";
        Connection conn = ConnectionFactory.getConnection();
        try {
            CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
            cachedRowSet.setCommand(sql);
            cachedRowSet.setInt(1, buyer.getId());
            cachedRowSet.execute(conn);
            conn.setAutoCommit(false);
            cachedRowSet.next();
            cachedRowSet.updateString("name", buyer.getName());
            cachedRowSet.updateRow();
//            Thread.sleep(8000); -> if the state of db change while we are disconnected, a SyncProviderException will be thrown.
//            Because .acceptChanges() check the state to see if still is the same as before.
            cachedRowSet.acceptChanges();
//            no need to close the connection because CachedRowSet close by it self
            ConnectionFactory.close(conn);
            System.out.println("Registro atualizado com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Buyer> selectAll() {
//        this query could return the data using *, but that way we know exactly the data that we are dealing in the resultSet
        String sql = "SELECT id, name, cpf FROM maratona_java.buyer;";
        Connection conn = ConnectionFactory.getConnection();
        List<Buyer> buyerList = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            ResultSet resultSet = stat.executeQuery(sql);
            while (resultSet.next()) {
                buyerList.add(new Buyer(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("name")));
            }
            ConnectionFactory.close(conn, stat, resultSet);
            return buyerList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Buyer> findByName(String searchTerm) {
        String sql = "SELECT id, name, cpf FROM maratona_java.buyer WHERE name LIKE '%" + searchTerm + "%'";
        Connection conn = ConnectionFactory.getConnection();
        List<Buyer> buyerList = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            ResultSet resultSet = stat.executeQuery(sql);
            while (resultSet.next()) {
                buyerList.add(new Buyer(resultSet.getInt("id"), resultSet.getString("cpf"), resultSet.getString("name")));
            }
            ConnectionFactory.close(conn, stat, resultSet);
            return buyerList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Buyer> findByNamePreparedStatement(String searchTerm) {
//        prepared statement is faster because precompile the query and is safer because don't use apostrophes, that way
//        prevent SQL injections attacks (BuyerDB_StudyReference.findByNamePreparedStatement("ohn' OR 'X'='X")).
//        To replace values, instead of concatenate strings, we use the placeholder '?'
        String sql = "SELECT id, name, cpf FROM maratona_java.buyer WHERE name LIKE ?";
        Connection conn = ConnectionFactory.getConnection();
        List<Buyer> buyerList = new ArrayList<>();
        try {
            PreparedStatement prepStat = conn.prepareStatement(sql);
            prepStat.setString(1, "%" + searchTerm + "%");
            ResultSet rs = prepStat.executeQuery();
            while (rs.next()) {
                buyerList.add(new Buyer(rs.getInt("id"), rs.getString("cpf"), rs.getString("name")));
            }
            ConnectionFactory.close(conn, prepStat, rs);
            return buyerList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Buyer> findByNameRowSet(String searchTerm) {
//        rowSet is simpler then PreparedStatement but it does have some differences from it:
//          we can't use Update, Insert or Delete operations in our DB
        String sql = "SELECT id, name, cpf FROM maratona_java.buyer WHERE name LIKE ?";
        JdbcRowSet jdbcRowSet = ConnectionFactory.getRowSetConnection();
        jdbcRowSet.addRowSetListener(new MyRowSetListener());
        List<Buyer> buyerList = new ArrayList<>();
        try {
            jdbcRowSet.setCommand(sql);
            jdbcRowSet.setString(1, "%" + searchTerm + "%");
            jdbcRowSet.execute();
            while (jdbcRowSet.next()) {
                buyerList.add(new Buyer(jdbcRowSet.getInt("id"), jdbcRowSet.getString("cpf"), jdbcRowSet.getString("name")));
            }
            ConnectionFactory.close(jdbcRowSet);
            return buyerList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    to use DB stored procedures, we use a CallableStatement
//    procedure that is call in the method .findByNameCallableStatement():
//    DELIMITER //
//      CREATE PROCEDURE SP_GetBuyersByName(searchTerm varchar(100))
//      BEGIN
//      SELECT * FROM buyer WHERE name like searchTerm;
//      END //
//    DELIMITER ;
    public static List<Buyer> findByNameCallableStatement(String searchTerm) {
        String sql = "CALL `maratona_java`.`SP_GetBuyersByName`(?)";
        Connection conn = ConnectionFactory.getConnection();
        List<Buyer> buyerList = new ArrayList<>();
        try {
            CallableStatement callStat = conn.prepareCall(sql);
            callStat.setString(1, "%" + searchTerm + "%");
            ResultSet rs = callStat.executeQuery();
            while (rs.next()) {
                buyerList.add(new Buyer(rs.getInt("id"), rs.getString("cpf"), rs.getString("name")));
            }
            ConnectionFactory.close(conn, callStat, rs);
            return buyerList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void selectMetaData() {
        String sql = "SELECT * FROM maratona_java.buyer;";
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
//            outside a while loop, rs.next() will bring only the first record in DB
            rs.next();
            int columnsNumber = rsmd.getColumnCount();
            System.out.println("quantidade de colunas: " + columnsNumber);
//            the first line is 1, not 0
            for (int i = 1; i <= columnsNumber; i++) {
                System.out.println("tabela: " + rsmd.getTableName(i));
                System.out.println("nome da coluna: " + rsmd.getColumnName(i));
                System.out.println("tamanho da coluna: " + rsmd.getColumnDisplaySize(i));
            }
            ConnectionFactory.close(conn, stat);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void checkDriverStatus() {
        Connection conn = ConnectionFactory.getConnection();
        try {
            DatabaseMetaData dbMetaData = conn.getMetaData();
//            the code below check what is the type of ResultSet
            if (dbMetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                System.out.println("suporta TYPE_FORWARD_ONLY");
                if (dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println("e tambem suporta CONCUR_UPDATABLE");
                }
            }

            if (dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                System.out.println("suporta TYPE_SCROLL_INSENSITIVE");
                if (dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println(" e tambem suporta CONCUR_UPDATABLE");
                }
            }

            if (dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                System.out.println("suporta TYPE_SCROLL_SENSITIVE");
                if (dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    System.out.println(" e tambem suporta CONCUR_UPDATABLE");
                }
            }
            ConnectionFactory.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void cursorPointerTypeScrollTest() {
        String sql = "SELECT id, name, cpf FROM maratona_java.buyer";
        Connection conn = ConnectionFactory.getConnection();
        try {
            Statement stat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stat.executeQuery(sql);
//            moves the cursor to last line. "ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY" must be added
//            as argument in .createStatement() method
            if (rs.last()) {
                System.out.println("ultima linha: " + new Buyer(rs.getInt("id"), rs.getString("cpf"), rs.getString("name")));
                System.out.println("numero da ultima linha: " + rs.getRow());
            }
            System.out.println("-----------------------------------------------------");
//            to return to first line:
            System.out.println("retornou para primeira linha? " + rs.first());
            System.out.println("posição atual: " + rs.getRow());
            System.out.println("-----------------------------------------------------");

//            .absolute() moves the cursor for any position in the rs
            System.out.println("moveu para linha 4? " + rs.absolute(4));
            System.out.println("posição atual: " + rs.getRow());
            System.out.println("linha 4: " + new Buyer(rs.getInt("id"), rs.getString("cpf"), rs.getString("name")));
            System.out.println("-----------------------------------------------------");

//            moves the cursor n positions forward or backward
            System.out.println("moveu 2 linhas a frente? " + rs.relative(2));
            System.out.println("posição atual: " + rs.getRow());
            System.out.println("-----------------------------------------------------");

//            check the position of the cursor
            System.out.println(rs.isFirst());
            System.out.println(rs.isBeforeFirst());
            System.out.println(rs.isLast());
            System.out.println(rs.isAfterLast());
            System.out.println("-----------------------------------------------------");

//            to iterate the rs in backwards
            rs.afterLast();
            while (rs.previous())
                System.out.println(new Buyer(rs.getInt("id"), rs.getString("cpf"), rs.getString("name")));
            ConnectionFactory.close(conn, stat, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateNamesToLowerCase() {
        String sql = "SELECT id, name, cpf FROM maratona_java.buyer;";
        Connection conn = ConnectionFactory.getConnection();
        try {

            Statement stat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stat.executeQuery(sql);
            if (rs.next()) {
//                update the specific value on the rs, then update in the DB
                rs.updateString("name", rs.getString("name").toLowerCase());
//                if we want to use updateString() more than once, the operation result is not trustable. So, before
//                update, if we need to cancel in a specific row, we must call rs.cancelRowUpdates(), then make the update.
//                This method can only be call one time
                rs.updateRow();
            }
            rs.beforeFirst();
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
            System.out.println("--------------------");

//            insert new record.
//            moveToInsertRow() method moves the cursor to a temp row where we can edit the columns values.
//            rs.absolute(2);
//            String name = rs.getString("name");
//            rs.moveToInsertRow();
//            rs.updateString("name", name.toUpperCase()); // set the name in the temp row
//            rs.updateString("cpf", "888.888.888-88");
//            rs.insertRow();
//            rs.moveToCurrentRow();
//            System.out.println(rs.getString("name") + " | row: " + rs.getRow());
//            System.out.println("--------------------");

//            delete a record
            rs.absolute(9);
            rs.deleteRow();

            ConnectionFactory.close(conn, stat, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
