package com.shreya.spring.controller;

import com.shreya.spring.model.Restaurant;
import com.shreya.spring.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/restaurantManagement")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/restaurant")
    public String createRestaurant(@RequestBody Restaurant restaurant) {
        try {
            restaurantService.insertRestaurant(restaurant);
            return "Restaurant added successfully!";
        } catch (SQLException e) {
            throw new RuntimeException("Error while inserting restaurant", e);
        }
    }

    @GetMapping("/restaurant")
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.retrieveRestaurants();
    }

    @GetMapping("/restaurant/{id}/{name}")
    public Restaurant getRestaurant(@PathVariable int id) {
        Restaurant restaurant = restaurantService.getRestaurantById(id);
        if (restaurant != null) {
            System.out.println("Restaurant Details: ");
            System.out.println("id: " + restaurant.getId());

        } else {
            System.out.println("Restaurant not found with id: " + id );
        }
        return restaurant;
    }

    @DeleteMapping("/restaurant/{id}")
    public String deleteRestaurant(@PathVariable int id) {
        try {
            if (restaurantService.deleteRestaurant(id)) {
                return "Restaurant deleted successfully!";
            } else {
                return "Failed to delete restaurant.";
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while deleting restaurant", e);
        }
    }

    @PutMapping("/restaurant/{id}")
    public String updateRestaurant(@PathVariable int id) {
        try {
            if (restaurantService.updateRestaurant(id)) {
                return "Restaurant updated successfully!";
            } else {
                return "Failed to update restaurant.";
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while updating restaurant", e);
        }
    }
}


