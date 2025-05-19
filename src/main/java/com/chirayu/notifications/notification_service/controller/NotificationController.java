package com.chirayu.notifications.notification_service.controller;

import com.chirayu.notifications.notification_service.dto.NotificationRequest;
import com.chirayu.notifications.notification_service.model.Notification;
import com.chirayu.notifications.notification_service.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping("/notifications")
    public ResponseEntity<Notification> sendNotification(@RequestBody NotificationRequest request) {
        return ResponseEntity.ok(service.sendNotification(request));
    }

    @GetMapping("/users/{userId}/notifications")
    public ResponseEntity<List<Notification>> getUserNotifications(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getNotificationsByUser(userId));
    }
}
