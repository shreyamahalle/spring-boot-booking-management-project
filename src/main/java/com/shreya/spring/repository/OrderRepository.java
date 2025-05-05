package com.shreya.spring.repository;

import com.shreya.spring.model.Order;
import com.shreya.spring.service.ConnectionService;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class OrderRepository {

    public String addOrder(Order order) throws SQLException {
        String query = "INSERT INTO orderr (id, type, note, paymentMethod) VALUES (?, ?, ?, ?)";

        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, order.getId());
            preparedStatement.setString(2, order.getType());
            preparedStatement.setString(3, order.getNote());
            preparedStatement.setString(4, order.getPaymentMethod());

            preparedStatement.executeUpdate();
        }
        return query;
    }

    public List<Order> retrieveOrders() {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM orderr";

        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String note = resultSet.getString("note");
                String paymentMethod = resultSet.getString("paymentMethod");

                orders.add(new Order(id, type, note, paymentMethod));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public Order retrieveOrder(int id, String type) {
        String sql = "SELECT * FROM orderr WHERE id = ? AND type = ?";
        Order order = null;

        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, type);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String note = resultSet.getString("note");
                String paymentMethod = resultSet.getString("paymentMethod");
                order = new Order(id, type, note, paymentMethod);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    public boolean deleteOrder(int id) throws SQLException {
        String sql = "DELETE FROM orderr WHERE id = ?";

        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        }
    }

    public boolean updateOrder(int id, String type) throws SQLException {
        String query = "UPDATE orderr SET type = ? WHERE id = ?";

        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, type);
            preparedStatement.setInt(2, id);
            return preparedStatement.executeUpdate() > 0;
        }
    }
}
