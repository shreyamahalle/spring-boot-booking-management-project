package com.shreya.spring.service.impl;

import com.shreya.spring.model.CartItem;
import com.shreya.spring.repository.CartItemRepository;
import com.shreya.spring.service.CartItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private final CartItemRepository cartItemRepository;

    @Override
    public boolean addCartItem(CartItem cartItem) throws SQLException {
        return cartItemRepository.addCartItem(cartItem);
    }

    @Override
    public boolean deleteCartItem(int id) {
        try {
            return cartItemRepository.deleteCartItem(id);
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting cart item", e);
        }
    }

    @Override
    public boolean updateCartItem(CartItem cartItem) throws SQLException {
        return cartItemRepository.updateCartItem(cartItem);
    }

    @Override
    public List<CartItem> retrieveCartItem() {
        try {
            return cartItemRepository.retrieveCartItems();
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving cart items", e);
        }
    }

    @Override
    public CartItem getCartItem(int id) {
        try {
            return cartItemRepository.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching cart item", e);
        }
    }

    @Override
    public boolean updatePartialCartItem(CartItem cartItem) {
        try {
            return cartItemRepository.updatePartialCartItem(cartItem);
        } catch (SQLException e) {
            throw new RuntimeException("Error partially updating cart item", e);
        }
    }
}
