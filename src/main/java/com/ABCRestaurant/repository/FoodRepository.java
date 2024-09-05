package com.example.ABCRestaurant.repository;

import com.example.ABCRestaurant.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FoodRepository extends JpaRepository<FoodItem, Long> {
    List<FoodItem> findAll();
}
