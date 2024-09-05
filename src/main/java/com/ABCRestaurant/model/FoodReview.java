package com.example.ABCRestaurant.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "food_review")
public class FoodReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    private Food food;

    private String reviewText;
    private int rating;  // Rating out of 5
    private LocalDateTime createdDate;

    public FoodReview() {}

    public FoodReview(User user, Food food, String reviewText, int rating) {
        this.user = user;
        this.food = food;
        this.reviewText = reviewText;
        this.rating = rating;
        this.createdDate = LocalDateTime.now();
    }

    // Getters and setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
