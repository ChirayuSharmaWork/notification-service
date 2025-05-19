package com.chirayu.notifications.notification_service.service;

import com.chirayu.notifications.notification_service.dto.NotificationRequest;
import com.chirayu.notifications.notification_service.kafka.KafkaNotificationProducer;
import com.chirayu.notifications.notification_service.model.Notification;
import com.chirayu.notifications.notification_service.repository.NotificationRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository repository;
    private final KafkaNotificationProducer kafkaProducer;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public NotificationService(NotificationRepository repository, KafkaNotificationProducer kafkaProducer) {
        this.repository = repository;
        this.kafkaProducer = kafkaProducer;
    }

    // ✅ This method sends the notification to Kafka
    public void sendNotificationViaKafka(NotificationRequest request) {
        try {
            String jsonMessage = objectMapper.writeValueAsString(request);
            kafkaProducer.sendMessage(jsonMessage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to convert notification request to JSON", e);
        }
    }

    // ✅ Keeps the original DB functionality for reading
    public List<Notification> getNotificationsByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    // (Optional) Keep if you want to send directly without Kafka (can be deleted if unused)
    public Notification sendNotification(NotificationRequest request) {
        Notification notification = new Notification();
        notification.setUserId(request.getUserId());
        notification.setMessage(request.getMessage());
        notification.setType(request.getType());
        notification.setTimestamp(LocalDateTime.now());
        return repository.save(notification);
    }
}
