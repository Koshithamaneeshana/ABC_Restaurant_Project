package com.abc.restaurant.service;

import com.abc.restaurant.model.SubMenu;
import com.abc.restaurant.repository.SubMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubMenuService {

    @Autowired
    private SubMenuRepository subMenuRepository;

    // Create or update a submenu
    public SubMenu addSubMenu(SubMenu subMenu) {
        return subMenuRepository.save(subMenu);
    }

    // Get submenu by ID
    public Optional<SubMenu> getSubMenuById(Long id) {
        return subMenuRepository.findById(id);
    }

    // Get all submenu items
    public List<SubMenu> getAllSubMenus() {
        return subMenuRepository.findAll();
    }

    public void updateSubMenu(Long id) {
        subMenuRepository.deleteById(id);
    }

    public void deleteSubMenu(Long id) {
        subMenuRepository.deleteById(id);
    }
}