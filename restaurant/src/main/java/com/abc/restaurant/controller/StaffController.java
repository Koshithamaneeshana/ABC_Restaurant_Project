package com.abc.restaurant.controller;

import com.abc.restaurant.model.Reservation;
import com.abc.restaurant.model.Staff;
import com.abc.restaurant.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @PostMapping("/register")
    public ResponseEntity<Staff> registerStaff(@RequestBody Staff staff) {
        return ResponseEntity.ok(staffService.registerStaff(staff));
    }

    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok(staffService.getAllReservations());
    }

    @PutMapping("/reservation/{id}/status")
    public ResponseEntity<Reservation> updateReservationStatus(@PathVariable Long id, @RequestParam String status) {
        return ResponseEntity.ok(staffService.updateReservationStatus(id, status));
    }
}