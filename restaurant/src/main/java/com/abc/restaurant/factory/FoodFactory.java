package com.abc.restaurant.factory;

import com.abc.restaurant.model.Food;
import org.springframework.stereotype.Component;

@Component
public class FoodFactory {

    public Food createFoodItem(String type, String name, double price, String description) {
        switch (type.toLowerCase()) {
            case "main_course":
                return new Food(name, price, description);  // Customize further as needed
            case "dessert":
                return new Food(name, price, description);
            case "beverage":
                return new Food(name, price, description);
            default:
                throw new IllegalArgumentException("Unknown food type: " + type);
        }
    }
}
