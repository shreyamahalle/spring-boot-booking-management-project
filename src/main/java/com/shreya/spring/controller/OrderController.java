package com.shreya.spring.controller;

import com.shreya.spring.exception.CustomerException;
import com.shreya.spring.model.Order;
import com.shreya.spring.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.sql.SQLException;
import java.util.Scanner;

@Controller
@Component
@AllArgsConstructor

public class OrderController {

    @Autowired
    private Scanner scanner;
    @Autowired
    private OrderService orderService;

    public void run() {
        int option;
        do {
            System.out.println("\n---- Order ----");
            System.out.println("1. Add Order");
            System.out.println("2. View Order Details");
            System.out.println("3. create Order on db");
            System.out.println("4. delete Order on db");
            System.out.println("5. Retrieve Order");
            System.out.println("6. Update Order");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");

            option = Integer.parseInt(scanner.nextLine());
            try {
                switch (option) {
                    case 1:
                        orderService.createOrder();
                        orderService.displayOrder();
                        orderService.displayOrder();
                        break;
                    case 2:
                        orderService.displayOrder();
                        break;
                    case 3:
                        System.out.println("Performing create operation on Order");
                        orderService.insertOrder(new Order(135, "pizza", "good", "gpay"));
                        break;
                    case 4:
                        System.out.println("delete Order");
                        orderService.deleteOrder();
                        break;
                    case 5:
                        System.out.println("Retrieve Order");
                        orderService.retrieveOrders().forEach(order -> {
                            System.out.println("order ID: " + order.getId() + ", type: " + order.getType());
                        });
                        break;
                    case 6:
                        System.out.println("Update Order");
                        orderService.updateOrder();

                    case 0:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (CustomerException e) {
                System.out.println("Error: " + e.getClass());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("All Good ");
            }
        } while (option != 0);
    }
}

