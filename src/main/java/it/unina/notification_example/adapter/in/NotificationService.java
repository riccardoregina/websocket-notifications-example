package it.unina.notification_example.adapter.in;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@EnableScheduling
public class NotificationService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void sendNotification(String message) {
        messagingTemplate.convertAndSend("/topic/notifications", message);
    }

    @Scheduled(fixedRate = 5000)
    public void sendPokeNotification() {
        sendNotification("Public update, time: " + LocalDateTime.now());
    }
}