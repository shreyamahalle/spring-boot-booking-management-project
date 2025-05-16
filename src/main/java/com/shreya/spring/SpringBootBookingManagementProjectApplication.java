package com.shreya.spring;

import com.shreya.spring.exception.InvalideCustomerIDException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class SpringBootBookingManagementProjectApplication {

    public static void main(String[] args) throws InvalideCustomerIDException, SQLException {

        SpringApplication.run(SpringBootBookingManagementProjectApplication.class, args);

    }
}
