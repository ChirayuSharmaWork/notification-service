package com.chirayu.notifications.notification_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaNotificationConsumer {

    @KafkaListener(topics = "notification-topic", groupId = "notification_group")
    public void consume(String message) {
        System.out.println("📩 Received message from Kafka: " + message);
        // Later: Convert message to Notification object and save
    }
}
