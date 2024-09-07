package com.abc.restaurant.model;

import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<Food> reservedFoods;

    @ManyToMany
    private List<SubMenu> reservedSubMenus;

    private String location;
    private LocalDateTime dateTime;
    private String status;

    @Transient
    private double totalPrice; // This field is transient and won't be persisted

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Food> getReservedFoods() {
        return reservedFoods;
    }

    public void setReservedFoods(List<Food> reservedFoods) {
        this.reservedFoods = reservedFoods;
    }

    public List<SubMenu> getReservedSubMenus() {
        return reservedSubMenus;
    }

    public void setReservedSubMenus(List<SubMenu> reservedSubMenus) {
        this.reservedSubMenus = reservedSubMenus;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    // Calculate the total price based on reserved items
    public double calculateTotalPrice() {
        double foodPrice = reservedFoods.stream()
                .mapToDouble(Food::getPrice)
                .sum();
        double subMenuPrice = reservedSubMenus.stream()
                .mapToDouble(SubMenu::getPrice)
                .sum();
        return foodPrice + subMenuPrice;
    }
}
