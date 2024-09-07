package com.abc.restaurant.repository;

import com.abc.restaurant.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation findByUser(User user);
}
