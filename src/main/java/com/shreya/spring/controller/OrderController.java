package com.shreya.spring.controller;

import com.shreya.spring.model.Order;
import com.shreya.spring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/orderManagement")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public String addOrder(@RequestBody Order order) throws SQLException {
        return orderService.addOrder(order);
    }

    @GetMapping("/order")
    public List<Order> getAllOrders() {
        return orderService.retrieveAllOrders();
    }

    @GetMapping("/order/{id}/{type}")
    public Order getOrderIdAndType(@PathVariable int id, @PathVariable String type) {
        return orderService.retrieveOrderByIdAndType(id, type);
    }

    @PutMapping("/order/{id}")
    public String updateOrder(@PathVariable int id, @RequestBody Order order) throws SQLException {
        order.setId(id);
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/order/{id}")
    public boolean deleteOrder(@PathVariable int id) throws SQLException {
        return orderService.deleteOrder(id);
    }
}
