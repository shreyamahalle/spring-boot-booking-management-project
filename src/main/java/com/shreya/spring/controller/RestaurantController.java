package com.shreya.spring.controller;

import com.shreya.spring.model.Restaurant;
import com.shreya.spring.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public String createRestaurant(@RequestBody Restaurant restaurant) {
        try {
            restaurantService.insertRestaurant(restaurant);
            return "Restaurant added successfully!";
        } catch (SQLException e) {
            throw new RuntimeException("Error while inserting restaurant", e);
        }
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.retrieveRestaurants();
    }

    @GetMapping("/{id}/{name}")
    public Restaurant getRestaurant(@PathVariable int id, @PathVariable String name) {
        Restaurant restaurant = restaurantService.getRestaurantById(id, name);
        if (restaurant != null) {
            System.out.println("Restaurant Details: ");
            System.out.println("id: " + restaurant.getId());
            System.out.println("Name: " + restaurant.getName());

        } else {
            System.out.println("Restaurant not found with id: " + id + " and Name: " + name);
        }

        return restaurant;
    }


    @DeleteMapping("/{id}")
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

    @PutMapping("/{id}")
    public String updateRestaurant(@PathVariable int id, @RequestParam String name) {
        try {
            if (restaurantService.updateRestaurant(id, name)) {
                return "Restaurant updated successfully!";
            } else {
                return "Failed to update restaurant.";
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while updating restaurant", e);
        }
    }
}


