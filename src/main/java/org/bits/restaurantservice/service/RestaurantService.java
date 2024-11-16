package org.bits.restaurantservice.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.bits.restaurantservice.repositories.RestaurantRepository;
import org.bits.restaurantservice.repositories.MenuItemRepository;

import org.bits.restaurantservice.model.Restaurant;
import org.bits.restaurantservice.model.MenuItem;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> getRestaurantById(Long id) {
        return restaurantRepository.findById(id);
    }

    public Restaurant updateRestaurant(Long id, Restaurant updatedRestaurant) {
        updatedRestaurant.setId(id);
        return restaurantRepository.save(updatedRestaurant);
    }

    public MenuItem addMenuItem(Long restaurantId, MenuItem menuItem) {
        menuItem.setRestaurantId(restaurantId);
        return menuItemRepository.save(menuItem);
    }

    public MenuItem updateMenuItem(Long restaurantId, Long itemId, MenuItem updatedMenuItem) {
        updatedMenuItem.setId(itemId);
        updatedMenuItem.setRestaurantId(restaurantId);
        return menuItemRepository.save(updatedMenuItem);
    }

    public void deleteMenuItem(Long restaurantId, Long itemId) {
        menuItemRepository.deleteById(itemId);
    }
}