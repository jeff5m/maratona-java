package br.com.abc.javacore.ZZCjdbc.db;

import br.com.abc.javacore.ZZCjdbc.classes.Buyer;
import br.com.abc.javacore.ZZCjdbc.conn.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BuyerDAO {
    public static void save(Buyer buyer) {
        String sql = "INSERT INTO `maratona_java`.`buyer` (`cpf`, `name`) VALUES (?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement prepStmt = conn.prepareStatement(sql)) {
            prepStmt.setString(1, buyer.getCpf());
            prepStmt.setString(2, buyer.getName());
            prepStmt.executeUpdate();
            System.out.println("Registro inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Buyer buyer) {
        if (buyer == null || buyer.getId() == null) {
            System.out.println("Não foi possível excluir o registro!");
            return;
        }
        String sql = "DELETE FROM `maratona_java`.`buyer` WHERE (`id` = ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement prepStmt = conn.prepareStatement(sql)) {
            prepStmt.setInt(1, buyer.getId());
            prepStmt.executeUpdate();
            System.out.println("Registro excluido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void update(Buyer buyer) {
        if (buyer == null || buyer.getId() == null) {
            System.out.println("Não foi possível atualizar o registro!");
            return;
        }
        String sql = "UPDATE `maratona_java`.`buyer` SET `cpf` = ?, `name` = ? WHERE (`id` = ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement prepStmt = conn.prepareStatement(sql)) {
            prepStmt.setString(1, buyer.getCpf());
            prepStmt.setString(2, buyer.getName());
            prepStmt.setInt(3, buyer.getId());
            prepStmt.executeUpdate();
            System.out.println("Registro atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Buyer> selectAll() {
        String sql = "SELECT id, name, cpf FROM maratona_java.buyer;";
        List<Buyer> buyerList = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement prepStmt = conn.prepareStatement(sql);
             ResultSet rs = prepStmt.executeQuery()) {
            while (rs.next()) {
                buyerList.add(new Buyer(rs.getInt("id"), rs.getString("cpf"), rs.getString("name")));
            }
            return buyerList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Buyer> searchByName(String searchTerm) {
        String sql = "SELECT id, name, cpf FROM maratona_java.buyer WHERE name LIKE ?";
        List<Buyer> buyerList = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement prepStmt = conn.prepareStatement(sql)) {
            prepStmt.setString(1, "%" + searchTerm + "%");
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                buyerList.add(new Buyer(rs.getInt("id"), rs.getString("cpf"), rs.getString("name")));
            }
            ConnectionFactory.close(conn, prepStmt, rs);
            return buyerList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Buyer searchById(Integer id) {
        String sql = "SELECT id, name, cpf FROM maratona_java.buyer WHERE id = ?";
        Buyer buyer = null;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement prepStmt = conn.prepareStatement(sql)) {
            prepStmt.setInt(1, id);
            ResultSet rs = prepStmt.executeQuery();
            if (rs.next()) {
                buyer = new Buyer(rs.getInt("id"), rs.getString("cpf"), rs.getString("name"));
            }
            ConnectionFactory.close(conn, prepStmt, rs);
            return buyer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
