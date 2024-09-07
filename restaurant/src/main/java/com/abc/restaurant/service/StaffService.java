package com.abc.restaurant.service;

import com.abc.restaurant.model.Staff;
import com.abc.restaurant.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    // Create or update staff
    public Staff saveStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    // Get staff by ID
    public Optional<Staff> getStaffById(Long id) {
        return staffRepository.findById(id);
    }

    // Get all staff members
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    // Delete a staff member by ID
    public void deleteStaffById(Long id) {
        staffRepository.deleteById(id);
    }

    // Get staff by email (for login)
    public Optional<Staff> getStaffByEmail(String email) {
        return staffRepository.findByEmail(email);
    }
}