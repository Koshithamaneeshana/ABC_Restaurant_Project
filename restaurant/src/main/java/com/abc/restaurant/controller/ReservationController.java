package com.abc.restaurant.controller;

import com.abc.restaurant.model.Food;
//import com.abc.restaurant.model.User;
import org.springframework.ui.Model;

import com.abc.restaurant.model.Reservation;
import com.abc.restaurant.repository.FoodRepository;
import com.abc.restaurant.repository.ReservationRepository;
import com.abc.restaurant.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.stereotype.Controller;

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
