package com.shreya.spring.repository;

import com.shreya.spring.model.Restaurant;
import com.shreya.spring.service.ConnectionService;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository

public class RestaurantRepository {

    private static Connection connection = null;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = new ConnectionService().getConnection();
        }
    }

    public void addRestaurant(Restaurant restaurant) throws SQLException {
        this.initConnection();
        String query = "insert into restaurant values (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, restaurant.getId());
            preparedStatement.setString(2, restaurant.getName());
            preparedStatement.setString(3, restaurant.getCity());
            preparedStatement.setString(4, restaurant.getArea());

            System.out.println("inserting restaurant data to table: " + restaurant);

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } finally { //close connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }

    public List<Restaurant> retrieveRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        String query = "SELECT * FROM restaurant";

        try {
            this.initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();
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
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }
        return restaurants;
    }

    public Restaurant retrieveRestaurant(int registerNo, String name) {
        Restaurant restaurant = null;
        String sql = "SELECT * FROM restaurant WHERE registerNo = ? AND name = ?";

        try {
            this.initConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, registerNo);
            preparedStatement.setString(2, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String city = resultSet.getString("city");
                String area = resultSet.getString("area");

                restaurant = new Restaurant(registerNo, name, city, area);
            }
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }
        return restaurant;
    }

    public boolean deleteRestaurant(int registerNo) throws SQLException {

        try {
            this.initConnection();
            String query = "DELETE FROM restaurant WHERE registerNo = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, registerNo);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("connection is closed: " + e.getMessage());
                }
            }
        }
    }

    public boolean updateRestaurant(int registerNo, String name) throws SQLException {
        Restaurant restaurant = null;
        try {
            this.initConnection();
            Statement statement = connection.createStatement();
            String sql = "UPDATE restaurant SET name = ? WHERE registerNo = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, registerNo);

                return preparedStatement.executeUpdate() > 0;
            }
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }
}


//    public boolean updateRestaurant(int registerno, String name) throws SQLException {
//        this.initConnection();
//
//        try {
//            System.out.println("Attempting to update restaurant with registerno: " + registerno + " and name: " + name);
//
//            // Check if the restaurant exists before attempting the update
//            String checkSql = "SELECT COUNT(*) FROM restaurant WHERE registerno = ?";
//            try (PreparedStatement checkStmt = connection.prepareStatement(checkSql)) {
//                checkStmt.setInt(1, registerno);
//                try (ResultSet resultSet = checkStmt.executeQuery()) {
//                    if (resultSet.next() && resultSet.getInt(1) == 0) {
//                        System.out.println("No restaurant found with ID " + registerno);
//                        return false;  // Return false if the ID does not exist
//                    }
//                }
//            }
//
//            // SQL update query
//            String sql = "UPDATE restaurant SET name = ? WHERE registerno = ?";
//            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//                preparedStatement.setString(1, name);
//                preparedStatement.setInt(2, registerno);
//
//                // Log the SQL before execution
//                System.out.println("Executing SQL: " + preparedStatement.toString());
//
//                int rowsUpdated = preparedStatement.executeUpdate();
//                if (rowsUpdated > 0) {
//                    System.out.println("Restaurant with ID " + registerno + " updated successfully.");
//                    return true;
//                } else {
//                    System.out.println("No rows updated for ID " + registerno);
//                    return false;
//                }
//            }
//        } catch (SQLException e) {
//            System.err.println("SQL error: " + e.getMessage());
//            throw new SQLException("Error while updating restaurant with ID " + registerno, e);
//        } finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    System.err.println("Error closing connection: " + e.getMessage());
//                }
//            }
//        }
//    }
//}