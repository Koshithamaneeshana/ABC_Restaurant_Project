package com.example.ABCRestaurant.config;

import com.example.ABCRestaurant.model.User;
import com.example.ABCRestaurant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public ApplicationRunner initializer() {
        return args -> {
            if (userRepository.findByUsername("admin") == null) {
                // Create default admin user
                User admin = new User("admin", new BCryptPasswordEncoder().encode("admin123"), "ROLE_ADMIN");
                userRepository.save(admin);
            }
        };
    }
}
