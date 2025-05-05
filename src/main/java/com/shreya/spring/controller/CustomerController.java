package com.shreya.spring.controller;

import com.shreya.spring.exception.CustomerNotfound;
import com.shreya.spring.model.Customer;
import com.shreya.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/customerManagement")  // Base URL: /customers
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer")
    public String addCustomer(@RequestBody Customer customer) throws SQLException {
        return customerService.addCustomer(customer);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.retrieveCustomers();
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable int id) throws CustomerNotfound {
        return customerService.getCustomerById(id);
    }

    @PutMapping("/customer/{id}")
    public boolean updateCustomer(@PathVariable int id, @RequestBody Customer customer) throws SQLException {
        customer.setId(id);
      return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/customer/{id}")
    public boolean deleteCustomer(@PathVariable int id) throws SQLException {
         return customerService.deleteCustomer(id);
    }

    @PatchMapping("/customer/{id}")
    public boolean updatePartialCustomer(@PathVariable("id") int id, @RequestBody Customer customer) throws SQLException {
        return  customerService.updatePartialCustomer(customer);
    }
}