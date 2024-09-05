package com.example.ABCRestaurant.factory;

import com.example.ABCRestaurant.model.FoodItem;
import org.springframework.stereotype.Component;

@Component
public class FoodFactory {

    public FoodItem createFoodItem(String type, String name, double price, String description) {
        switch (type.toLowerCase()) {
            case "main_course":
                return new FoodItem(name, price, description);  // Customize further as needed
            case "dessert":
                return new FoodItem(name, price, description);
            case "beverage":
                return new FoodItem(name, price, description);
            default:
                throw new IllegalArgumentException("Unknown food type: " + type);
        }
    }
}

