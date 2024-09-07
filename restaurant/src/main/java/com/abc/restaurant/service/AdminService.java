package com.abc.restaurant.service;

import com.abc.restaurant.model.Food;
import com.abc.restaurant.model.SubMenu;
import com.abc.restaurant.model.Reservation;
import com.abc.restaurant.model.User;
import com.abc.restaurant.repository.FoodRepository;
import com.abc.restaurant.repository.SubMenuRepository;
import com.abc.restaurant.repository.ReservationRepository;
import com.abc.restaurant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final FoodRepository foodRepository;
    private final SubMenuRepository subMenuRepository;
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;

    @Autowired
    public AdminService(FoodRepository foodRepository, SubMenuRepository subMenuRepository,
                        ReservationRepository reservationRepository, UserRepository userRepository) {
        this.foodRepository = foodRepository;
        this.subMenuRepository = subMenuRepository;
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
    }

    // Manage Food Items
    public Food addFood(Food food) {
        return foodRepository.save(food);
    }

    public Food updateFood(Food food) {
        return foodRepository.save(food);
    }

    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }

    public Optional<Food> getFoodById(Long id) {
        return foodRepository.findById(id);
    }

    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    // Manage SubMenus
    public SubMenu addSubMenu(SubMenu subMenu) {
        return subMenuRepository.save(subMenu);
    }

    public SubMenu updateSubMenu(SubMenu subMenu) {
        return subMenuRepository.save(subMenu);
    }

    public void deleteSubMenu(Long id) {
        subMenuRepository.deleteById(id);
    }

    public Optional<SubMenu> getSubMenuById(Long id) {
        return subMenuRepository.findById(id);
    }

    public List<SubMenu> getAllSubMenus() {
        return subMenuRepository.findAll();
    }

    // Manage Reservations
    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        reservations.forEach(reservation -> reservation.setTotalPrice(reservation.calculateTotalPrice()));
        return reservations;
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id).map(reservation -> {
            reservation.setTotalPrice(reservation.calculateTotalPrice());
            return reservation;
        });
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    // Manage Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Calculate Total Income (assuming Reservation has a total price field)
    public double calculateTotalIncome() {
        return reservationRepository.findAll().stream()
                .mapToDouble(reservation -> {
                    reservation.setTotalPrice(reservation.calculateTotalPrice());
                    return reservation.getTotalPrice();
                })
                .sum();
    }

    // Calculate Reservations Summary
    public List<Reservation> getReservationsSummary() {
        return reservationRepository.findAll();
    }
}