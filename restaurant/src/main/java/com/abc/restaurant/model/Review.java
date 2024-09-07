package com.abc.restaurant.model;

public class Review {
    private Long id;
    private Long reservationId;
    private String reviewText;
    private int rating; // Rating between 1-5

    public Review() {
    }

    public Review(Long reservationId, String reviewText, int rating) {
        this.reservationId = reservationId;
        this.reviewText = reviewText;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}