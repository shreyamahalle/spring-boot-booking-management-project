package com.shreya.spring.service;
import com.shreya.spring.model.CartItem;

import java.sql.SQLException;

public interface CartItemService {

    boolean addCartItem(CartItem cartItem) throws SQLException;


}
