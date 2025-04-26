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

    public List<Order> getAllOrders() {
        return orderRepository.retrieveOrders();
    }

    public Order getOrderByIdAndType(int id, String type) {
        return orderRepository.retrieveOrder(id, type);
    }

    public String updateOrder(int id, String type) {
        try {
            boolean updated = orderRepository.updateOrder(id, type);
            return updated ? "Order updated successfully." : "Order not found or not updated.";
        } catch (SQLException e) {
            return "Error while updating order: " + e.getMessage();
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
