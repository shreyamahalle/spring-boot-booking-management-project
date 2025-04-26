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

    @GetMapping("/{registerno}/{name}")
    public Restaurant getRestaurant(@PathVariable int registerno, @PathVariable String name) {
        return restaurantService.getRestaurantById(registerno, name);
    }

    @DeleteMapping("/{registerno}")
    public String deleteRestaurant(@PathVariable int registerno) {
        try {
            if (restaurantService.deleteRestaurant(registerno)) {
                return "Restaurant deleted successfully!";
            } else {
                return "Failed to delete restaurant.";
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while deleting restaurant", e);
        }
    }

    @PutMapping("/{registerNo}")
    public String updateRestaurant(@PathVariable int registerNo, @RequestParam String name) {
        try {
            if (restaurantService.updateRestaurant(registerNo, name)) {
                return "Restaurant updated successfully!";
            } else {
                return "Failed to update restaurant.";
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while updating restaurant", e);
        }
    }
}


//    @PutMapping("/{registerno}")
//    public ResponseEntity<String> updateRestaurant(@PathVariable int registerno, @RequestParam String name) {
//        try {
//            boolean updated = restaurantService.updateRestaurant(registerno, name);
//            if (updated) {
//                return ResponseEntity.ok("Restaurant updated successfully!");
//            } else {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                        .body("Failed to update restaurant.");
//            }
//        } catch (SQLException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Error while updating restaurant: " + e.getMessage());
//        }
//    }
//}