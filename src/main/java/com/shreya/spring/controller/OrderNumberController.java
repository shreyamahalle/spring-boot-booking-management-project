package com.shreya.spring.controller;

import com.shreya.spring.exception.CustomerException;
import com.shreya.spring.model.Order;
import com.shreya.spring.service.OrderService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
@Component
public class OrderNumberController {

    private OrderService orderService;
    Order order = new Order();
    private Scanner scanner;

    public void run() {
        int option;
        do {
            System.out.println("\n---- Order ----");
            System.out.println("1. View Order Details");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");

            option = Integer.parseInt(scanner.nextLine());
            try {
                switch (option) {
                    case 1:
                        orderService.createOrder();
                        orderService.displayOrder();
                        System.out.print("Order " + order);
                        break;
                    case 2:
                        orderService.displayOrder();
                        break;
                    case 0:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (CustomerException e) {
                System.out.println("Error: " + e.getClass());
            } finally {
                System.out.println("All Good ");
            }
        } while (option != 0);
    }
}

