package com.shreya.spring.repository;

import com.shreya.spring.model.Notification;
import com.shreya.spring.service.ConnectionService;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class NotificationRepository {

    public boolean saveNotification(Notification notification) throws SQLException {
        String query = "INSERT INTO notification (customer_id, message, is_read) VALUES (?, ?, ?)";

        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setLong(1, notification.getCustomer_id());
            ps.setString(2, notification.getMessage());
            ps.setBoolean(3, notification.is_read());

            return ps.executeUpdate() > 0;
        }
    }

    public List<Notification> getAllNotifications() {
        List<Notification> notifications = new ArrayList<>();
        String query = "SELECT * FROM notification";

        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                notifications.add(new Notification(
                        rs.getLong("id"),
                        rs.getLong("customer_id"),
                        rs.getString("message"),
                        rs.getBoolean("is_read"),
                        rs.getString("timestamp")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return notifications;
    }

    public List<Notification> getNotificationsByCustomerId(Long customerId) {
        List<Notification> notifications = new ArrayList<>();
        String query = "SELECT * FROM notification WHERE customer_id = ?";

        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setLong(1, customerId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                notifications.add(new Notification(
                        rs.getLong("id"),
                        rs.getLong("customer_id"),
                        rs.getString("message"),
                        rs.getBoolean("is_read"),
                        rs.getString("timestamp")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return notifications;
    }

    public boolean markAsRead(Long id) {
        String query = "UPDATE notification SET is_read = TRUE WHERE id = ?";

        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
