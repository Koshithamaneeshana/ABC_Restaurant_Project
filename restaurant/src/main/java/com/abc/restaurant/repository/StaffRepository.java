package com.abc.restaurant.repository;

import com.abc.restaurant.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    // Find staff by email for login
    Optional<Staff> findByEmail(String email);
}