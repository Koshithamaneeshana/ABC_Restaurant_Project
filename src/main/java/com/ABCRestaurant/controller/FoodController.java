package com.example.ABCRestaurant.controller;

import com.example.ABCRestaurant.factory.FoodFactory;
import com.example.ABCRestaurant.model.FoodItem;
import com.example.ABCRestaurant.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private FoodFactory foodFactory;

    @GetMapping("/menu")
    public String getFoodMenu(Model model) {
        model.addAttribute("foodItems", foodService.getAllFoodItems());
        return "food_menu";
    }

    @GetMapping("/add")
    public String addFoodForm(Model model) {
        model.addAttribute("foodItem", new FoodItem());
        return "food_form";
    }

    @PostMapping("/save")
    public String saveFood(@RequestParam("type") String type, @ModelAttribute FoodItem foodItem) {
        FoodItem newFoodItem = foodFactory.createFoodItem(type, foodItem.getName(), foodItem.getPrice(), foodItem.getDescription());
        foodService.saveFoodItem(newFoodItem);
        return "redirect:/food/menu";
    }

    @GetMapping("/edit/{id}")
    public String editFoodForm(@PathVariable Long id, Model model) {
        FoodItem foodItem = foodService.getFoodItemById(id);
        model.addAttribute("foodItem", foodItem);
        return "food_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteFood(@PathVariable Long id) {
        foodService.deleteFoodItem(id);
        return "redirect:/food/menu";
    }
}
