package com.shreya.spring.repository;

import com.shreya.spring.model.CartItem;
import com.shreya.spring.service.ConnectionService;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CartItemRepository {

    public boolean addCartItem(CartItem cartItem) {

        String query = "INSERT INTO cart_item (customer_id ,menu_item_id, quantity) VALUES ( ?, ?, ?)";

        try (Connection connection = ConnectionService.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setLong(1, cartItem.getCustomer_id());
            ps.setLong(2, cartItem.getMenu_item_id());  // Correct field name
            ps.setInt(3, cartItem.getQuantity());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;  // Returns true if the item was added successfully

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<CartItem> retrieveCartItems(){
        List<CartItem> cartItemList = new ArrayList<>();
        return cartItemList;
    }
}
