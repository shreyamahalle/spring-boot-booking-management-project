package com.shreya.spring.controller;

import com.shreya.spring.model.MenuItem;
import com.shreya.spring.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/menuItemManagement")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @PostMapping("/menuItem")
    public boolean addMenuItem(@RequestBody MenuItem menuItem) throws SQLException {
        return menuItemService.addMenuItem(menuItem);
    }

    @GetMapping("/menuItem")
    public List<MenuItem> getAllMenuItems() {
        return menuItemService.getAllMenuItems();
    }

    @GetMapping("/menuItem/{id}")
    public MenuItem getMenuItemById(@PathVariable long id) {
        return menuItemService.getMenuItemById(id);
    }

    @DeleteMapping("/menuItem/{id}")
    public boolean deleteMenuItem(@PathVariable long id) {
        return menuItemService.deleteMenuItem(id);
    }

    @PutMapping("/menuItem/{id}")
    public boolean updateMenuItem(@PathVariable long id, @RequestBody MenuItem menuItem) {
        menuItem.setId(id);  // Ensure the id is set correctly in the object
        return menuItemService.updateMenuItem(menuItem);
    }
}
