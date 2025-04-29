package com.shreya.spring.repository;

import com.shreya.spring.model.OrderStatus;
import com.shreya.spring.service.ConnectionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Repository
public class OrderStatusRepository {

    public boolean addorderStatus(OrderStatus orderStatus) {
        String query = "INSERT INTO order_status (status, description) VALUES (?, ?)";

        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, orderStatus.getStatus());
            preparedStatement.setString(2, orderStatus.getDescription());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<OrderStatus> retrieveOrderStatuses() throws SQLException {
        List<OrderStatus> orderStatuses = new ArrayList<>();
        String query = "SELECT * FROM order_status";

        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                OrderStatus orderStatus = new OrderStatus(
                        resultSet.getLong("id"),
                        resultSet.getString("status"),
                        resultSet.getString("description")
                );
                orderStatuses.add(orderStatus);
            }

        }
        return orderStatuses;
    }

    public OrderStatus retrieveOrderStatus(long id) throws SQLException {
        OrderStatus orderStatus = null;
        String query = "SELECT * FROM order_status WHERE id = ?";
        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String status = resultSet.getString("status");
                String description = resultSet.getString("description");

                orderStatus = new OrderStatus(id, status, description);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderStatus;
    }

    public boolean updateOrderStatus(OrderStatus orderStatus) {
        String query = "UPDATE order_status SET status = ?, description = ? WHERE id = ?";
        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, orderStatus.getStatus());
            preparedStatement.setString(2, orderStatus.getDescription());
            preparedStatement.setLong(3, orderStatus.getId());

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteOrderStatus(long id) {
        String query = "DELETE FROM order_status WHERE id = ?";
        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, id);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
            throw new RuntimeException(e);  // Re-throw exception
        }
    }
}
