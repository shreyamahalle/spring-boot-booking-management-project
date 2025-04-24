package com.shreya.spring.service;

import com.shreya.spring.model.Order;
import com.shreya.spring.repository.OrderRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

@Service
@Data

public class OrderService implements OrderNumberService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private Scanner scanner;

    public void createOrder() {

        try {
            System.out.println("Please enter id");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.println("Please enter type");
            String type = scanner.nextLine();

            System.out.println("Please enter note");
            String note = scanner.nextLine();

            System.out.println("Please enter paymentMethod");
            String paymentMethod = scanner.nextLine();

        } catch (Exception e) {
            System.out.println("Invalid input type correct data");
        }
    }

    public void insertOrder(Order order) throws SQLException {
        orderRepository.addOrder(order);
    }

    public void Order(Order order) throws SQLException {

        orderRepository.retrieveOrder(1, "abc");
    }

    public void deleteOrder() {

        try {
            if (orderRepository.deleteOrder(1)) {
                System.out.println("Order deleted successfully!");
            } else {
                System.out.println("Failed to delete Order.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateOrder() throws SQLException {
        if (orderRepository.updateOrder(2, "meal")) {
            System.out.println("Order updated successfully ");
        } else {
            System.out.println("Failed to update Order");
        }

    }

    public void deleteOrder(int orderId) {
        String removeOrder = String.valueOf(orderId);
        System.out.println("remove order " + removeOrder);
    }

    public List<Order> retrieveOrders() {
        return orderRepository.retrieveOrders();
    }

    @Override
    public void createOrderNo() {
    }

    public void displayOrder() {
        try {
//            Set<Map.Entry<Integer, Order>> entrySet = orders.entrySet();
//            for (Map.Entry<Integer, Order> customerEntry : entrySet) {
//                System.out.println("Customer Info: " + orders);
//            }

            //java 8 features forEach loop..
            //orders.forEach((Id, orders) -> System.out.println("orderId " + Id + " = order info " + orders));

        } catch (Exception e) {
            System.out.println("Invalid input type correct data");
        }

    }
}