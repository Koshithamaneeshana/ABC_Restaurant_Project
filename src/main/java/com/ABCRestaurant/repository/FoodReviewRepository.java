package com.example.ABCRestaurant.repository;

import com.example.ABCRestaurant.model.Food;
import com.example.ABCRestaurant.model.FoodReview;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FoodReviewRepository extends JpaRepository<FoodReview, Long> {
    List<FoodReview> findByFood(Food food);
}
