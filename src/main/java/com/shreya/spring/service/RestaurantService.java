package com.shreya.spring.service;

import com.shreya.spring.model.Restaurant;
import com.shreya.spring.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    // 1. Insert Restaurant to Database
    public void insertRestaurant(Restaurant restaurant) throws SQLException {
        restaurantRepository.addRestaurant(restaurant);
    }

    // 2. Retrieve all Restaurants from Database
    public List<Restaurant> retrieveRestaurants() {
        return restaurantRepository.retrieveRestaurants();
    }

    // 3. Retrieve a Single Restaurant (optional)
    public Restaurant getRestaurantById(int id, String name) {
        return restaurantRepository.retrieveRestaurant(id, name);
    }

    // 4. Delete Restaurant by ID
    public boolean deleteRestaurant(int id) throws SQLException {
        return restaurantRepository.deleteRestaurant(id);
    }

    // 5. Update Restaurant Name by ID
    public boolean updateRestaurant(int id, String name) throws SQLException {
        return restaurantRepository.updateRestaurant(id, name);
    }
}
