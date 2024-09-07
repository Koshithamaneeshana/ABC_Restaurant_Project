package com.abc.restaurant.controller;

import com.abc.restaurant.model.Food;
import com.abc.restaurant.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/menu")
    public ResponseEntity<List<Food>> getAllMenu() {
        return ResponseEntity.ok(foodService.getAllMenu());
    }

    @GetMapping("/menu/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable Long id) {
        return ResponseEntity.ok(foodService.getFoodById(id));
    }
}
