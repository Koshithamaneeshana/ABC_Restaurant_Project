package com.abc.restaurant.controller;

import com.abc.restaurant.model.Food;
import com.abc.restaurant.service.AdminService;
import com.abc.restaurant.service.ReservationService;
import com.abc.restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class AdminController {
    @RestController
    @RequestMapping("/admin")
    public class AdminController {

        @Autowired
        private AdminService adminService;

        @Autowired
        private UserService userService;

        @Autowired
        private ReservationService reservationService;

        // CRUD for Food
        @PostMapping("/addFood")
        public ResponseEntity<Food> addFood(@RequestBody Food food) {
            return ResponseEntity.ok(adminService.addFood(food));
        }

        @PutMapping("/updateFood/{id}")
        public ResponseEntity<Food> updateFood(@PathVariable Long id, @RequestBody Food food) {
            return ResponseEntity.ok(adminService.updateFood(id, food));
        }

        @DeleteMapping("/deleteFood/{id}")
        public ResponseEntity<String> deleteFood(@PathVariable Long id) {
            adminService.deleteFood(id);
            return ResponseEntity.ok("Food deleted successfully.");
        }

        // User Management
        @DeleteMapping("/deleteUser/{id}")
        public ResponseEntity<String> deleteUser(@PathVariable Long id) {
            userService.deleteUser(id);
            return ResponseEntity.ok("User deleted successfully.");
        }

        // Reservation and Summary
        @GetMapping("/summary")
        public ResponseEntity<String> getSummary() {
            return ResponseEntity.ok(reservationService.getSummaryReport());
        }
    }
}
