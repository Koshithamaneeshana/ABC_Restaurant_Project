package com.abc.restaurant.repository;

import com.abc.restaurant.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Find all reviews by reservationId
    List<Review> findByReservationId(Long reservationId);
}