package com.abc.restaurant.service;

import com.abc.restaurant.model.Review;
import com.abc.restaurant.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    // Create or update a review
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    // Get review by ID
    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    // Get all reviews
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Get reviews by reservation ID
    public List<Review> getReviewsByReservationId(Long reservationId) {
        return reviewRepository.findByReservationId(reservationId);
    }

    // Delete review by ID
    public void deleteReviewById(Long id) {
        reviewRepository.deleteById(id);
    }
}