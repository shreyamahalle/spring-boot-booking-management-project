package com.shreya.spring.repository;

import com.shreya.spring.model.MenuItem;
import com.shreya.spring.service.ConnectionService;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class MenuItemRepository {

    public boolean addMenuItem(MenuItem menuItem) throws SQLException {
        String query = "INSERT INTO menu_item (name, description, price, restaurant_id) VALUES (?, ?, ?, ?)";

        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, menuItem.getName());
            ps.setString(2, menuItem.getDescription());
            ps.setDouble(3, menuItem.getPrice());
            ps.setLong(4, menuItem.getRestaurantId());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        }
    }

    public List<MenuItem> retrieveMenuItems() {
        List<MenuItem> menuItems = new ArrayList<>();
        String query = "SELECT * FROM menu_item";

        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                MenuItem menuItem = new MenuItem(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getLong("restaurant_id")
                );
                menuItems.add(menuItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menuItems;
    }

    public MenuItem findById(long id) {
        String query = "SELECT * FROM menu_item WHERE id = ?";
        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new MenuItem(
                            rs.getLong("id"),
                            rs.getString("name"),
                            rs.getString("description"),
                            rs.getDouble("price"),
                            rs.getLong("restaurant_id")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean deleteMenuItem(long id) {
        String query = "DELETE FROM menu_item WHERE id = ?";
        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setLong(1, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateMenuItem(MenuItem menuItem) {
        String query = "UPDATE menu_item SET name = ?, description = ?, price = ?, restaurant_id = ? WHERE id = ?";
        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, menuItem.getName());
            ps.setString(2, menuItem.getDescription());
            ps.setDouble(3, menuItem.getPrice());
            ps.setLong(4, menuItem.getRestaurantId());
            ps.setLong(5, menuItem.getId());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
