package com.shreya.spring.controller;

import com.shreya.spring.exception.DeliveryAgentException;
import com.shreya.spring.service.DeliveryAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
@Component
public class DeliveryAgentController {

    //  Autowire the service properly
    @Autowired
    private DeliveryAgentService deliveryAgentService;
    @Autowired
    private Scanner scanner;

    public void run() {
        int option;
        do {
            System.out.println("---- DeliveryAgent ----");
            System.out.println("1. Add DeliveryAgent");
            System.out.println("2. View DeliveryAgent Details");
            System.out.println("3. create DeliveryAgent in db");
            System.out.println("4. delete DeliveryAgent in db");
            System.out.println("5. Retrieve DeliveryAgent");
            System.out.println("0. Back to the Main Menu");
            System.out.print("Enter choice: ");

            option = Integer.parseInt(scanner.nextLine());
            try {
                switch (option) {
                    case 1 -> {
                        deliveryAgentService.createDeliveryAgent();
                        deliveryAgentService.displayDeliveryAgent();
                    }
                    case 2 -> deliveryAgentService.displayDeliveryAgent();
                    case 3 -> {
                        System.out.println("Performing create operation on deliveryAgent");
                        deliveryAgentService.insertDeliveryAgent();
                    }
                    case 4 -> {
                        System.out.println("delete deliveryAgent");
                        deliveryAgentService.deleteDeliveryAgent();
                    }
                    case 5 -> {
                        System.out.println("Retrieve DeliveryAgent");
                        deliveryAgentService.retrieveDeliveryAgents().forEach(deliveryAgent -> {
                            System.out.println("DeliveryAgent ID: " + deliveryAgent.getId() +
                                    ", name: " + deliveryAgent.getName());
                        });
                    }
                    case 0 -> System.out.println("Returning to Main Menu...");
                    default -> System.out.println("Invalid choice! Try again.");
                }
            } catch (DeliveryAgentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (option != 0);
    }
}
