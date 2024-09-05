package com.example.ABCRestaurant.controller;

import com.example.ABCRestaurant.model.Food;
import com.example.ABCRestaurant.model.Reservation;
import com.example.ABCRestaurant.model.User;
import com.example.ABCRestaurant.repository.FoodRepository;
import com.example.ABCRestaurant.repository.ReservationRepository;
import com.example.ABCRestaurant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReservationController {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/reservation")
    public String viewReservation(Model model, Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName());
        Reservation reservation = reservationRepository.findByUser(user);
        model.addAttribute("reservation", reservation);
        model.addAttribute("totalPrice", reservation.getTotalPrice());
        return "reservation";
    }

    @PostMapping("/reservation/add/{foodId}")
    public String addToReservation(@PathVariable("foodId") Long foodId, Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName());
        Reservation reservation = reservationRepository.findByUser(user);
        if (reservation == null) {
            reservation = new Reservation(user);
        }
        Food food = foodRepository.findById(foodId).orElseThrow();
        reservation.addFoodItem(food);
        reservationRepository.save(reservation);
        return "redirect:/food/menu";
    }

    @PostMapping("/reservation/remove/{foodId}")
    public String removeFromReservation(@PathVariable("foodId") Long foodId, Authentication authentication) {
        User user = userRepository.findByUsername(authentication.getName());
        Reservation reservation = reservationRepository.findByUser(user);
        Food food = foodRepository.findById(foodId).orElseThrow();
        reservation.removeFoodItem(food);
        reservationRepository.save(reservation);
        return "redirect:/reservation";
    }
}
