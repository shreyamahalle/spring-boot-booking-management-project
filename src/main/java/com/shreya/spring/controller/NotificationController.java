package com.shreya.spring.controller;

import com.shreya.spring.model.Notification;
import com.shreya.spring.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/notificationManagement")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public boolean addNotification(@RequestBody Notification notification) throws SQLException {
        return notificationService.saveNotification(notification);
    }

    @GetMapping
    public List<Notification> getAll() {
        return notificationService.getAllNotifications();
    }

    @GetMapping("/customer/{customerId}")
    public List<Notification> getByCustomer(@PathVariable Long customerId) {
        return notificationService.getNotificationsByCustomerId(customerId);
    }

    @PutMapping("/read/{id}")
    public boolean markAsRead(@PathVariable Long id) {
        return notificationService.markAsRead(id);
    }
}
