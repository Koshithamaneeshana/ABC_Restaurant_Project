package com.abc.restaurant.service;

import com.abc.restaurant.model.Reservation;
import com.abc.restaurant.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    // Create or update reservation
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // Get reservation by ID
    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    // Get all reservations
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    // Get reservations by user ID
    public List<Reservation> getReservationsByUserId(Long userId) {
        return reservationRepository.findByUserId(userId);
    }

    // Delete reservation by ID
    public void deleteReservationById(Long id) {
        reservationRepository.deleteById(id);
    }
}