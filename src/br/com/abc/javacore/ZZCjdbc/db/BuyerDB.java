package br.com.abc.javacore.ZZCjdbc.db;

import br.com.abc.javacore.ZZCjdbc.classes.Buyer;
import br.com.abc.javacore.ZZCjdbc.conn.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
}
