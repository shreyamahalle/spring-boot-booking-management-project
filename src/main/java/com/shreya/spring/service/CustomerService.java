package com.shreya.spring.service;

import com.shreya.spring.exception.CustomerNotfound;
import com.shreya.spring.model.Customer;
import com.shreya.spring.repository.CustomerRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

@Service
@Data

public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private Scanner scanner;

    public void insertCustomer() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pls enter customer id:");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Pls enter customer name:");
        String name = scanner.nextLine();
        System.out.println("Pls enter city:");
        String city = scanner.nextLine();
        System.out.println("Pls enter mobileNo :");
        int mobileNo = scanner.nextInt();
        System.out.println("enter age");
        int age = scanner.nextInt();

        Customer customer = new Customer(id, name, city, mobileNo, age);

        try {
            if (customerRepository.addCustomer(customer)) {
                System.out.println("Customer inserted successfully!");
            } else {
                System.out.println("Failed to insert Customer.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCustomer() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter customer ID to delete:");
            int id = Integer.parseInt(sc.nextLine());

            if (customerRepository.deleteCustomer(id)) {
                System.out.println("Customer deleted successfully!");
            } else {
                System.out.println("Failed to delete Customer.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }
    }

    public void updateCustomer() throws SQLException {
        if (customerRepository.updateCustomer(2, "shreya")) {
            System.out.println("Customer updated successfully ");
        } else {
            System.out.println("Failed to update customer");
        }

    }

    public List<Customer> retrieveCustomers() {
        return customerRepository.retrieveCustomers();
    }

    public void displayCustomerInfo() throws CustomerNotfound {
    }

    public void createCustomer() {
        Customer customer = new Customer();
        customerRepository.createCustomer(customer);

        try {
            System.out.println("Please enter customer details:");

            System.out.print("Enter ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter City: ");
            String city = scanner.nextLine();

            System.out.print("Enter Mobile Number: ");
            int mobileNo = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            customer.setId(id);
            customer.setName(name);
            customer.setCity(city);
            customer.setMobileNo(mobileNo);
            customer.setAge(age);

            // Insert into DB
            customerRepository.createCustomer(customer);

            System.out.println("Customer created successfully!");
        } catch (Exception e) {
            System.out.println("Invalid input. Please check the data and try again.");
        }
    }

    public void displayCustomers() {

    }
}
