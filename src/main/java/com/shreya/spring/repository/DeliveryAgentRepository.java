package com.shreya.spring.repository;

import com.shreya.spring.model.DeliveryAgent;
import com.shreya.spring.service.ConnectionService;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DeliveryAgentRepository {

    public boolean addDeliveryAgent(DeliveryAgent deliveryAgent) throws SQLException {
        String query = "INSERT INTO deliveryAgent (id, name, city, mobileNo) VALUES (?, ?, ?, ?)";

        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, deliveryAgent.getId());
            ps.setString(2, deliveryAgent.getName());
            ps.setString(3, deliveryAgent.getCity());
            ps.setInt(4, deliveryAgent.getMobileNo());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public List<DeliveryAgent> retrieveDeliveryAgents() {
        List<DeliveryAgent> deliveryAgents = new ArrayList<>();
        String query = "SELECT * FROM deliveryAgent";

        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                DeliveryAgent deliveryAgent = new DeliveryAgent(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("city"),
                        rs.getInt("mobileNo")
                );
                deliveryAgents.add(deliveryAgent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deliveryAgents;
    }

    public DeliveryAgent findById(int id) throws SQLException {
        String query = "SELECT * FROM deliveryagent WHERE id = ?";
        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new DeliveryAgent(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("city"),
                            rs.getInt("mobileNo")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if no DeliveryAgent is found
    }

    public boolean deleteDeliveryAgent(int id) {
        String query = "DELETE FROM deliveryAgent WHERE id = ?";
        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean updateDeliveryAgent(DeliveryAgent deliveryAgent) {
        String query = "UPDATE deliveryAgent SET name = ?, city = ?, mobileNo = ? WHERE id = ?";

        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, deliveryAgent.getName());
            ps.setString(2, deliveryAgent.getCity());
            ps.setInt(3, deliveryAgent.getMobileNo());
            ps.setInt(4, deliveryAgent.getId());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
