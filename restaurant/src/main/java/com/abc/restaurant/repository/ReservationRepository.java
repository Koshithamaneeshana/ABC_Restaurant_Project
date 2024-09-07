package com.abc.restaurant.repository;

import com.abc.restaurant.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // Find all reservations by userId
    List<Reservation> findByUserId(Long userId);
}
