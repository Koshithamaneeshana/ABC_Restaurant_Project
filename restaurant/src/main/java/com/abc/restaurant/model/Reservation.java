package com.abc.restaurant.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "reservation_food",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    private List<Food> reservedFoodItems = new ArrayList<>();

    public Reservation() {}

    public Reservation(User user) {
        this.user = user;
    }

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

    public List<Food> getReservedFoodItems() {
        return reservedFoodItems;
    }

    public void setReservedFoodItems(List<Food> reservedFoodItems) {
        this.reservedFoodItems = reservedFoodItems;
    }

    public void addFoodItem(Food food) {
        this.reservedFoodItems.add(food);
    }

    public void removeFoodItem(Food food) {
        this.reservedFoodItems.remove(food);
    }

    public double getTotalPrice() {
        return reservedFoodItems.stream().mapToDouble(Food::getPrice).sum();
    }
}
