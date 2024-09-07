package com.abc.restaurant.controller;

import com.abc.restaurant.model.Food;
import com.abc.restaurant.model.FoodReview;
import com.abc.restaurant.model.User;
import com.abc.restaurant.repository.FoodRepository;
import com.abc.restaurant.repository.FoodReviewRepository;
import com.abc.restaurant.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReviewController {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private FoodReviewRepository foodReviewRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/food/{foodId}/reviews")
    public String viewReviews(@PathVariable("foodId") Long foodId, Model model) {
        Food food = foodRepository.findById(foodId).orElseThrow();
        List<FoodReview> reviews = foodReviewRepository.findByFood(food);
        model.addAttribute("food", food);
        model.addAttribute("reviews", reviews);
        return "food_reviews";
    }

    @PostMapping("/food/{foodId}/reviews/add")
    public String addReview(@PathVariable("foodId") Long foodId,
                            @RequestParam("reviewText") String reviewText,
                            @RequestParam("rating") int rating,
                            Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName());
        Food food = foodRepository.findById(foodId).orElseThrow();
        FoodReview review = new FoodReview(user, food, reviewText, rating);
        foodReviewRepository.save(review);
        return "redirect:/food/" + foodId + "/reviews";
    }
}
