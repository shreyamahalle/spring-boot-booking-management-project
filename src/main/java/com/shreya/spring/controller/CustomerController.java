package com.shreya.spring.controller;

import com.shreya.spring.exception.CustomerNotfound;
import com.shreya.spring.model.Customer;
import com.shreya.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/customermanagement")  // Base URL: /customers
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public String addCustomer(@RequestBody Customer customer) throws SQLException {
        customerService.addCustomer(customer);
        return "Customer created successfully!";
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.retrieveCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) throws CustomerNotfound {
        return customerService.getCustomerById(id);
    }

    @PutMapping("/{id}")
    public String updateCustomer(@PathVariable int id, @RequestBody Customer customer) throws SQLException {
        customer.setId(id);
        customerService.updateCustomer(customer);
        return "Customer updated successfully!";
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable int id) throws SQLException {
        customerService.deleteCustomer(id);
        return "Customer deleted successfully!";
    }
}
