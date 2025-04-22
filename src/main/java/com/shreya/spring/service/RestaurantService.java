package com.shreya.spring.service;

import com.shreya.spring.model.Restaurant;
import com.shreya.spring.repository.RestaurantRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

@Service
@Data

public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private Scanner scanner;

    public static void displayRestaurant() {
        try {
//            restaurants.forEach((id, restaurant) ->
//                    System.out.println("Restaurant Id " + id + " = " + restaurant));
        } catch (Exception e) {
            System.out.println("Invalid input type. Please enter correct data.");
        }
    }

    public List<Restaurant> retrieveRestaurants() {
        return restaurantRepository.retrieveRestaurants();
    }

    public void insertRestaurant(Restaurant restaurant) throws SQLException {
        restaurantRepository.addRestaurant(restaurant);
    }

    public void Restaurant(Restaurant restaurant) {
        restaurantRepository.retrieveRestaurant(1, "abc");
    }

    public void deleteRestaurant() {
        try {
            if (restaurantRepository.deleteRestaurant(1)) {
                System.out.println("Restaurant deleted successfully!");
            } else {
                System.out.println("Failed to delete Restaurant.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateRestaurant() throws SQLException {
        if (restaurantRepository.updateRestaurant(2, "shreya")) {
            System.out.println("Restaurant updated successfully");
        } else {
            System.out.println("Failed to update Restaurant");
        }
    }

    public void createRestaurant() {
        try {
            System.out.println("Please enter registerNo");
            int registerNo = Integer.parseInt(scanner.nextLine());

            System.out.println("Please enter name");
            String name = scanner.nextLine();

            System.out.println("Please enter city");
            String city = scanner.nextLine();

            System.out.println("Please enter area");
            String area = scanner.nextLine();

        } catch (Exception e) {
            System.out.println("Invalid input type. Please enter correct data.");
        }
    }
}
