package com.shreya.spring.repository;

import com.shreya.spring.model.CartItem;
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
public class CartItemRepository {

    public boolean addCartItem(CartItem cartItem) {

        String query = "INSERT INTO cart_item (customer_id ,menu_item_id, quantity) VALUES (?, ?, ?)";

        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            //ps.setLong(1, cartItem.getId());
            ps.setLong(1, cartItem.getCustomer_id());
            ps.setLong(2, cartItem.getMenu_item_id());  // Correct field name
            ps.setInt(3, cartItem.getQuantity());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;  // Returns true if the item was added successfully

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<CartItem> retrieveCartItems() throws SQLException {
        List<CartItem> cartItemList = new ArrayList<>();
        String query = "SELECT * FROM cart_item";

        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                CartItem cartItem = new CartItem(
                        rs.getLong("id"),
                        rs.getLong("customer_id"),
                        rs.getLong("menu_item_id"),
                        rs.getInt("quantity")
                );
                cartItemList.add(cartItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartItemList;
    }


    public CartItem findById(int id) throws SQLException {
        String query = "SELECT * FROM cart_item WHERE id = ?";
        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new CartItem(
                            rs.getLong("id"),
                            rs.getLong("customer_id"),
                            rs.getLong("menu_item_id"),
                            rs.getInt("quantity")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteCartItem(int id) throws SQLException {
        String query = "DELETE FROM cart_item WHERE id = ?";
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

    public boolean updateCartItem(CartItem cartItem) throws SQLException {
        String query = "UPDATE cart_item SET customer_id = ?, menu_item_id = ?,quantity = ?";
        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setLong(1, cartItem.getCustomer_id());
            ps.setLong(2, cartItem.getMenu_item_id());
            ps.setInt(3, cartItem.getQuantity());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updatePartialCartItem(CartItem cartItem) throws SQLException {
        String query = "UPDATE cart_item set customer_id = ?, menu_item_id = ?,quantity = ?";
        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setLong(1,cartItem.getCustomer_id());
            ps.setLong(2,cartItem.getMenu_item_id());
            ps.setInt(3,cartItem.getQuantity());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

