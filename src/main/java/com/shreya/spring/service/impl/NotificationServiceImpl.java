package com.shreya.spring.service.impl;

import com.shreya.spring.model.Notification;
import com.shreya.spring.repository.NotificationRepository;
import com.shreya.spring.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public boolean saveNotification(Notification notification) throws SQLException {
        return notificationRepository.saveNotification(notification);
    }

    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.getAllNotifications();
    }

    @Override
    public List<Notification> getNotificationsByCustomerId(Long customerId) {
        return notificationRepository.getNotificationsByCustomerId(customerId);
    }

    @Override
    public boolean markAsRead(Long id) {
        return notificationRepository.markAsRead(id);
    }
}
