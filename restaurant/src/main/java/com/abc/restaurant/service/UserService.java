package com.abc.restaurant.service;

import com.abc.restaurant.model.Reservation;
import com.abc.restaurant.model.User;
import com.abc.restaurant.repository.ReservationRepository;
import com.abc.restaurant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, ReservationRepository reservationRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encrypt password
        userRepository.save(user);
    }


    public boolean loginUser(String email, String password) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }

    public List<Reservation> getUserReservations(Long userId) {
        return reservationRepository.findByUserId(userId);
    }


    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}