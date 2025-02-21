package it.unina.notification_example.port.in;

import it.unina.notification_example.model.Notification;
import it.unina.notification_example.model.User;
import it.unina.notification_example.port.out.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@EnableScheduling
public class NotificationService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @Autowired
    private NotificationRepository notificationRepository;

    public void sendNotification(List<User> users, String message) {
        users.forEach(user -> {
            var notification = new Notification(
                    user.getId(),
                    message,
                    LocalDateTime.now(),
                    false
            );
            notificationRepository.save(notification);
            messagingTemplate.convertAndSend("/topic/private/" + user.getUsername(), notification);
        });
    }

    public List<Notification> getNotifications(String userId) {
        return notificationRepository.findAllByUserId(userId);
    }
}