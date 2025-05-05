package com.shreya.spring.service.impl;

import com.shreya.spring.exception.CustomerNotfound;
import com.shreya.spring.model.Customer;
import com.shreya.spring.repository.CustomerRepository;
import com.shreya.spring.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private final CustomerRepository customerRepository;

    public String addCustomer(Customer customer) throws SQLException, SQLException {
        customerRepository.addCustomer(customer);
        return null;
    }

    public boolean deleteCustomer(int id) throws SQLException {
        return customerRepository.deleteCustomer(id);
    }

    public boolean updateCustomer(Customer customer) throws SQLException {
        return customerRepository.updateCustomer(customer);
    }


    public List<Customer> retrieveCustomers() {
        return customerRepository.retrieveCustomers();
    }

    public Customer getCustomerById(int id) throws CustomerNotfound {
        Customer customer = customerRepository.findById(id);
        if (customer != null) {
            return customer;
        } else {
            throw new CustomerNotfound("Customer not found with ID: " + id);
        }
    }

    public boolean updatePartialCustomer(Customer customer) throws SQLException {
        return customerRepository.updatePartialCustomer(customer);
    }
}
