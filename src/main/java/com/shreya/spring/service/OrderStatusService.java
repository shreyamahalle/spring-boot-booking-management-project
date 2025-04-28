package com.shreya.spring.service;

import com.shreya.spring.model.OrderStatus;
import com.shreya.spring.repository.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class OrderStatusService {

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    public boolean addOrderStatus(OrderStatus orderStatus) throws SQLException {
        return orderStatusRepository.addorderStatus(orderStatus);
    }

    public List<OrderStatus> getAllOrderStatus() throws SQLException {
        return orderStatusRepository.retrieveOrderStatuses();
    }

    public OrderStatus getOrderStatusById(Long id) throws SQLException {
        return orderStatusRepository.retrieveOrderStatus(id);
    }

    public boolean updateOrderStatus(OrderStatus orderStatus) {
        return orderStatusRepository.updateOrderStatus(orderStatus);
    }

    public boolean deleteOrderStatus(Long id) {
        return orderStatusRepository.deleteOrderStatus(id);
    }
}
