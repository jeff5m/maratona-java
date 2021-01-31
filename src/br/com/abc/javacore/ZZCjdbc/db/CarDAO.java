package br.com.abc.javacore.ZZCjdbc.db;

import br.com.abc.javacore.ZZCjdbc.classes.Buyer;
import br.com.abc.javacore.ZZCjdbc.classes.Car;
import br.com.abc.javacore.ZZCjdbc.classes.Car;
import br.com.abc.javacore.ZZCjdbc.conn.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {

    public static void save(Car car) {
        String sql = "INSERT INTO `maratona_java`.`car` (`license_plate`, `name`, `buyer_id`) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement prepStmt = conn.prepareStatement(sql)) {
            prepStmt.setString(1, car.getLicense_plate());
            prepStmt.setString(2, car.getName());
            prepStmt.setInt(3, car.getBuyer().getId());
            prepStmt.executeUpdate();
            System.out.println("Registro inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Car car) {
        if (car == null || car.getId() == null) {
            System.out.println("Não foi possível excluir o registro!");
            return;
        }
        String sql = "DELETE FROM `maratona_java`.`car` WHERE (`id` = ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement prepStmt = conn.prepareStatement(sql)) {
            prepStmt.setInt(1, car.getId());
            prepStmt.executeUpdate();
            System.out.println("Registro excluido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void update(Car car) {
        if (car == null || car.getId() == null) {
            System.out.println("Não foi possível atualizar o registro!");
            return;
        }
        String sql = "UPDATE `maratona_java`.`car` SET `license_plate` = ?, `name` = ? WHERE (`id` = ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement prepStmt = conn.prepareStatement(sql)) {
            prepStmt.setString(1, car.getLicense_plate());
            prepStmt.setString(2, car.getName());
            prepStmt.setInt(3, car.getId());
            prepStmt.executeUpdate();
            System.out.println("Registro atualizado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Car> selectAll() {
        String sql = "SELECT id, license_plate, name, buyer_id FROM maratona_java.car;";
        List<Car> carList = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement prepStmt = conn.prepareStatement(sql);
             ResultSet rs = prepStmt.executeQuery()) {
            while (rs.next()) {
                Buyer buyer = BuyerDAO.searchById(rs.getInt("buyer_id"));
                carList.add(new Car(rs.getInt("id"), rs.getString("license_plate"), rs.getString("name"), buyer));
            }
            return carList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Car> searchByName(String searchTerm) {
        String sql = "SELECT id, license_plate, name, buyer_id FROM maratona_java.car WHERE name LIKE ?";

        List<Car> carList = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement prepStmt = conn.prepareStatement(sql)) {
            prepStmt.setString(1, "%" + searchTerm + "%");
            ResultSet rs = prepStmt.executeQuery();
            while (rs.next()) {
                Buyer buyer = BuyerDAO.searchById(rs.getInt("buyer_id"));
                carList.add(new Car(rs.getInt("id"), rs.getString("license_plate"), rs.getString("name"), buyer));
            }
            ConnectionFactory.close(conn, prepStmt, rs);
            return carList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
