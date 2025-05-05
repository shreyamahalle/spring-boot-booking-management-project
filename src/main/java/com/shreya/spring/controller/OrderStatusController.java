package com.shreya.spring.controller;

import com.shreya.spring.model.OrderStatus;
import com.shreya.spring.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/orderStatusManagement")
public class OrderStatusController {

    @Autowired
    private OrderStatusService orderStatusService;

    @PostMapping("/orderStatus")
    public boolean addOrderStatus(@RequestBody OrderStatus orderStatus) throws SQLException {
        return orderStatusService.addOrderStatus(orderStatus);
    }

    @GetMapping("/orderStatus")
    public List<OrderStatus> getAllOrderStatus() throws SQLException {
        return orderStatusService.getAllOrderStatus();
    }

    @GetMapping("/orderStatus/{id}")
    public OrderStatus getOrderStatusById(@PathVariable long id) throws SQLException {
        return orderStatusService.getOrderStatusById(id);
    }

    @PutMapping("/orderStatus/{id}")
    public boolean updateOrderStatus(@PathVariable long id, OrderStatus orderStatus) {
        orderStatus.setId(id);
        return orderStatusService.updateOrderStatus(orderStatus);
    }

    @DeleteMapping("/orderStatus/{id}")
    public boolean deleteOderStatus(@PathVariable long id) {
        return orderStatusService.deleteOrderStatus(id);
    }
}
