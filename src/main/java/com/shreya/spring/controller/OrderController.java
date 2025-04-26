package com.shreya.spring.controller;

import com.shreya.spring.model.Order;
import com.shreya.spring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public String addOrder(@RequestBody Order order){
        orderService.addOrder(order);
        return "Oder created successfully!!!!";
    }
    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.retrieveAllOrders();
    }

    @GetMapping("/{id}/{type}")
    public Order getOrderIdAndType(int id,String type){
        return  orderService.retrieveOrderByIdAndType(id,type);
    }
    @PutMapping("/{id}")
    public String updateOrder(@PathVariable int id, @RequestBody Order order) throws SQLException {
        order.setId(id);
        orderService.updateOrder(order);
        return "Order updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable int id) throws SQLException {
        boolean success = Boolean.parseBoolean(orderService.deleteOrder(id));
        return success ? "Order deleted successfully" : "Failed to delete Order";
    }
}