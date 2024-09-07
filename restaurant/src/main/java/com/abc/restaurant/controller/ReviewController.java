package com.abc.restaurant.controller;

import com.abc.restaurant.model.Review;
import com.abc.restaurant.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/add")
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        return ResponseEntity.ok(reviewService.addReview(review));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Review>> getAllReviews() {
        return ResponseEntity.ok(reviewService.getAllReviews());
    }
}