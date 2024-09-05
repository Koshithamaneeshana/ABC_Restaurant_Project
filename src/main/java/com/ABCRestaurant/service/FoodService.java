package com.example.ABCRestaurant.service;

import com.example.ABCRestaurant.model.FoodItem;
import com.example.ABCRestaurant.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    private static FoodService instance;

    @Autowired
    private FoodRepository foodRepository;

    // Private constructor for Singleton pattern
    private FoodService() {}

    public static FoodService getInstance() {
        if (instance == null) {
            instance = new FoodService();
        }
        return instance;
    }

    public List<FoodItem> getAllFoodItems() {
        return foodRepository.findAll();
    }

    public void saveFoodItem(FoodItem foodItem) {
        foodRepository.save(foodItem);
    }

    public FoodItem getFoodItemById(Long id) {
        return foodRepository.findById(id).orElse(null);
    }

    public void deleteFoodItem(Long id) {
        foodRepository.deleteById(id);
    }
}
