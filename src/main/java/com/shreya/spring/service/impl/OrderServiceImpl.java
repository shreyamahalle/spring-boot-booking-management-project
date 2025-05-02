package com.shreya.spring.service.impl;

import com.shreya.spring.model.Order;
import com.shreya.spring.repository.OrderRepository;
import com.shreya.spring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service

public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public String addOrder(Order order) throws SQLException {
        return orderRepository.addOrder(order);
    }

    @Override
    public List<Order> retrieveAllOrders() {
        return orderRepository.retrieveOrders();
    }

    @Override
    public Order retrieveOrderByIdAndType(int id, String type) {
        return orderRepository.retrieveOrder(id, type);
    }

    @Override
    public String updateOrder(Order order) throws SQLException {
        int orderId = order.getId();
        String orderType = order.getType();
        boolean updated = orderRepository.updateOrder(orderId, orderType);  // Update the order
        return orderType;
    }

    @Override
    public boolean deleteOrder(int id) throws SQLException {
        return orderRepository.deleteOrder(id);
    }
}