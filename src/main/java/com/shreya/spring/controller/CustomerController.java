package com.shreya.spring.controller;

import com.shreya.spring.exception.CustomerException;
import com.shreya.spring.exception.CustomerNotfound;
import com.shreya.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Scanner;

@RestController
public class CustomerController {

    @Autowired
    private Scanner scanner;
    @Autowired
    private CustomerService customerService;

    public void run() {

        int option;
        do {
            System.out.println("\n---- Customer ----");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customer Details");
            System.out.println("3. create Customer on db");
            System.out.println("4. delete Customer on db");
            System.out.println("5. Retrieve Customer");
            System.out.println("6. Update Customer");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter choice: ");

            option = Integer.parseInt(this.scanner.nextLine());
            try {
                switch (option) {
                    case 1:
                        customerService.createCustomer();
                        customerService.displayCustomerInfo();
                        break;
                    case 2:
                        customerService.displayCustomers();
                        break;
                    case 3:
                        System.out.println("Performing create operation on Customer");
                        customerService.createCustomer();
                        break;
                    case 4:
                        System.out.println("delete Customer");
                        customerService.deleteCustomer();
                        break;
                    case 5:
                        System.out.println("Retrieve Customer");
                        customerService.retrieveCustomers().forEach(customer -> {
                            System.out.println("customer ID: " + customer.getId() + ", name: " + customer.getName());
                        });
                        break;
                    case 6:
                        System.out.println("Update Customer");
                        customerService.updateCustomer();
                        break;

                    case 0:
                        System.out.println("Returning to Main Menu...");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (CustomerException e) {
                System.out.println("Error: " + e.getClass());
            } catch (CustomerNotfound | SQLException e) {
                throw new RuntimeException(e);
            }
        } while (option != 0);
    }
}