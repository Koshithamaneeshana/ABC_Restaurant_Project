package com.abc.restaurant.service;

import com.abc.restaurant.model.Food;
import com.abc.restaurant.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    // Create or update food
    public Food saveFood(Food food) {
        return foodRepository.save(food);
    }

    // Get food by ID
    public Optional<Food> getFoodById(Long id) {
        return foodRepository.findById(id);
    }

    // Get all food items
    public List<Food> getAllFoodItems() {
        return foodRepository.findAll();
    }

    // Delete food by ID
    public void deleteFoodById(Long id) {
        foodRepository.deleteById(id);
    }
}