package com.abc.restaurant.controller;

import com.abc.restaurant.model.SubMenu;
import com.abc.restaurant.service.SubMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/submenu")
public class SubMenuController {

    private final SubMenuService subMenuService;

    @Autowired
    public SubMenuController(SubMenuService subMenuService) {
        this.subMenuService = subMenuService;
    }

    @GetMapping("/all")
    public String getAllSubMenus(Model model) {
        List<SubMenu> subMenus = subMenuService.getAllSubMenus();
        model.addAttribute("subMenus", subMenus);
        return "submenu_list"; // Thymeleaf template
    }

    @GetMapping("/add")
    public String showAddSubMenuForm(Model model) {
        model.addAttribute("subMenu", new SubMenu());
        return "submenu_add"; // Thymeleaf template
    }

    @PostMapping("/add")
    public String addSubMenu(@ModelAttribute SubMenu subMenu) {
        subMenuService.addSubMenu(subMenu);
        return "redirect:/submenu/all";
    }

    @GetMapping("/edit/{id}")
    public String showEditSubMenuForm(@PathVariable Long id, Model model) {
        Optional<SubMenu> subMenu = subMenuService.getSubMenuById(id);
        model.addAttribute("subMenu", subMenu);
        return "submenu_edit"; // Thymeleaf template
    }

    @PostMapping("/edit")
    public String updateSubMenu(@ModelAttribute SubMenu subMenu) {
        subMenuService.updateSubMenu(subMenu.getId());
        return "redirect:/submenu/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteSubMenu(@PathVariable Long id) {
        subMenuService.deleteSubMenu(id);
        return "redirect:/submenu/all";
    }
}