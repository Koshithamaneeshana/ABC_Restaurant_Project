package com.abc.restaurant.repository;

import com.abc.restaurant.model.SubMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubMenuRepository extends JpaRepository<SubMenu, Long> {
    // Additional custom query methods can be added here if necessary
}