package com.shreya.spring.controller;

import com.shreya.spring.model.CartItem;
import com.shreya.spring.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/cartItemManagement")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping("/cartItem")
    public boolean addCardItem(@RequestBody CartItem cartItem) throws SQLException {
        return cartItemService.addCartItem(cartItem);
    }
}
