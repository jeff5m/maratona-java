package br.com.abc.javacore.ZZCjdbc.db;

import br.com.abc.javacore.ZZCjdbc.classes.Buyer;
import br.com.abc.javacore.ZZCjdbc.conn.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BuyerDB {
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

        String sql = "UPDATE `maratona_java`.`buyer` SET `cpf` = '" + buyer.getCpf() + "', `name` = '" + buyer.getName() + "' WHERE (`id` = '" + buyer.getId() + "');";
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
}
