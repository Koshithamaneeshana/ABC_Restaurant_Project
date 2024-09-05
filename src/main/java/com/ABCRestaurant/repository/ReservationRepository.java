package com.example.ABCRestaurant.repository;

import com.example.ABCRestaurant.model.Reservation;
import com.example.ABCRestaurant.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation findByUser(User user);
}
