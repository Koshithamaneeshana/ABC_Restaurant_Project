package com.abc.restaurant.repository;

import java.util.List;

import com.abc.restaurant.model.Food;
import com.abc.restaurant.model.FoodReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodReviewRepository extends JpaRepository<FoodReview, Long> {
    List<FoodReview> findByFood(Food food);
}
