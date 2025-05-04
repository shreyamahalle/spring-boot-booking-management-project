package com.shreya.spring.controller;

import com.shreya.spring.model.CartItem;
import com.shreya.spring.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/cartItemManagement")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping("/cartItem")
    public boolean addCardItem(@RequestBody CartItem cartItem) throws SQLException {
        return cartItemService.addCartItem(cartItem);
    }

    @GetMapping("/cartItem")
    public List<CartItem> getAllCartItems() {
        return cartItemService.retrieveCartItem();
    }

    @GetMapping("/cartItem/{id}")
    public CartItem getCartItemById(@PathVariable int id) {
        return cartItemService.getCartItem(id);
    }

    @DeleteMapping("/cartItem/{id}")
    public boolean deleteCartItem(@PathVariable int id){
        return cartItemService.deleteCartItem(id);
    }

    // Partial Update Cart Item
    @PatchMapping("/cartItem")
    public boolean updatePartialCartItem(@RequestBody CartItem cartItem) {
        return cartItemService.updatePartialCartItem(cartItem);
    }
    @PutMapping("/cartItem")
    public boolean updateCartItem(CartItem cartItem) throws SQLException {
        return cartItemService.updateCartItem(cartItem);
    }
}
