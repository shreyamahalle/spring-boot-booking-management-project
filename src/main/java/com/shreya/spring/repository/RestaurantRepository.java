package com.shreya.spring.repository;

import com.shreya.spring.model.Restaurant;
import com.shreya.spring.service.ConnectionService;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository

public class RestaurantRepository {

    public void addRestaurant(Restaurant restaurant) throws SQLException {
        String query = "INSERT INTO restaurant (registerNo, name, city, area) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, restaurant.getId());
            preparedStatement.setString(2, restaurant.getName());
            preparedStatement.setString(3, restaurant.getCity());
            preparedStatement.setString(4, restaurant.getArea());

            preparedStatement.executeUpdate();
            System.out.println("Inserting restaurant data to table: " + restaurant);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Restaurant> retrieveRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        String query = "SELECT * FROM restaurant";

        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int registerNo = resultSet.getInt("registerNo");
                String name = resultSet.getString("name");
                String city = resultSet.getString("city");
                String area = resultSet.getString("area");

                Restaurant restaurant = new Restaurant(registerNo, name, city, area);
                restaurants.add(restaurant);
            }
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        }
        return restaurants;
    }

    public Restaurant retrieveRestaurant(int registerNo, String name) {
        Restaurant restaurant = null;
        String sql = "SELECT * FROM restaurant WHERE registerNo = ? AND name = ?";

        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, registerNo);
            preparedStatement.setString(2, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String city = resultSet.getString("city");
                    String area = resultSet.getString("area");

                    restaurant = new Restaurant(registerNo, name, city, area);
                }
            }
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        }
        return restaurant;
    }

    public boolean deleteRestaurant(int registerNo) throws SQLException {
        String query = "DELETE FROM restaurant WHERE registerNo = ?";
        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, registerNo);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateRestaurant(int registerNo, String name) throws SQLException {
        String sql = "UPDATE restaurant SET name = ? WHERE registerNo = ?";
        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, registerNo);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
