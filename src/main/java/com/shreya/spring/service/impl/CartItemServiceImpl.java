package com.shreya.spring.service.impl;

import com.shreya.spring.model.CartItem;
import com.shreya.spring.repository.CartItemRepository;
import com.shreya.spring.service.CartItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@AllArgsConstructor
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public boolean addCartItem(CartItem cartItem) throws SQLException {
        return cartItemRepository.addCartItem(cartItem); // Returning the result from the repository
    }
}