package com.abc.restaurant.controller;

import com.abc.restaurant.model.Reservation;
import com.abc.restaurant.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/reservations")
public class ReservationController {

    private final AdminService adminService;

    @Autowired
    public ReservationController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return adminService.getAllReservations();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservationById(@PathVariable Long id) {
        return adminService.getReservationById(id);
    }

    @GetMapping("/total-income")
    public double getTotalIncome() {
        return adminService.calculateTotalIncome();
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Long id) {
        adminService.deleteReservation(id);
    }
}