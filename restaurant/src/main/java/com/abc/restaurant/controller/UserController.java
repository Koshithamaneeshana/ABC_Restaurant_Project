package com.abc.restaurant.controller;

import com.abc.restaurant.model.Reservation;
import com.abc.restaurant.model.User;
import com.abc.restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/reservations")
    public String getUserReservations(@RequestParam Long userId, Model model) {
        List<Reservation> reservations = userService.getUserReservations(userId);
        model.addAttribute("reservations", reservations);
        return "user_reservations"; // Thymeleaf template
    }


    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "user_profile"; // Thymeleaf template for user profile
        }
        return "error"; // Error page if user not found
    }


    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register"; // Thymeleaf template for registration
    }


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@ModelAttribute User user) {
        try {
            userService.registerUser(user);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User registration failed");
        }
    }


    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Thymeleaf template for login
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String email, @RequestParam String password) {
        boolean isLoggedIn = userService.loginUser(email, password);
        if (isLoggedIn) {
            return ResponseEntity.ok("Login successful"); // Redirect to dashboard in actual implementation
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }


    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        // Add any necessary data to the model
        return "user_dashboard"; // Thymeleaf template for user dashboard
    }


    @GetMapping("/logout")
    public String logoutUser() {
        // Logic for logging out the user (handled by Spring Security)
        return "redirect:/login"; // Redirect to login page
    }
}