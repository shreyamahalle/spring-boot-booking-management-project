package com.shreya.spring.service;

import com.shreya.spring.model.Order;
import com.shreya.spring.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public String addOrder(Order order) {
        try {
            orderRepository.addOrder(order);
            return "Order added successfully.";
        } catch (SQLException e) {
            return "Error while adding order: " + e.getMessage();
        }
    }

    // Retrieve all orders
    public List<Order> retrieveAllOrders() {
        return orderRepository.retrieveOrders();
    }

    // Retrieve specific order by id and type
    public Order retrieveOrderByIdAndType(int id, String type) {
        return orderRepository.retrieveOrder(id, type);
    }

    public String updateOrder(Order order) throws SQLException {
        int orderId = order.getId();
        String orderType = order.getType();

        boolean updated = orderRepository.updateOrder(orderId, orderType);  // Update the order
        if (updated) {
            return "Order updated successfully!";
        } else {
            return "Failed to update Order.";
        }
    }

    public String deleteOrder(int id) {
        try {
            boolean deleted = orderRepository.deleteOrder(id);
            return deleted ? "Order deleted successfully." : "Order not found or not deleted.";
        } catch (SQLException e) {
            return "Error while deleting order: " + e.getMessage();
        }
    }
}
