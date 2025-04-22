package com.shreya.spring.impl;

import com.shreya.spring.model.Customer;
import com.shreya.spring.model.Order;
import com.shreya.spring.repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
public class CustomerImpl extends Customer {

    OrderRepository orderRepository = new OrderRepository();
    HashMap<Integer, Order> orders = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    public void printCustomer() {
        //System.out.println(order);
    }

    public Order createOrder() {

        try {
            System.out.println("Please enter id");
            int id = Integer.parseInt(sc.nextLine());

            System.out.println("Please enter type");
            String type = sc.nextLine();

            System.out.println("Please enter note");
            String note = sc.nextLine();

            System.out.println("Please enter paymentMethod");
            String paymentMethod = sc.nextLine();

        } catch (Exception e) {
            System.out.println("Invalid input type correct data");
        }
        return null;
    }
}