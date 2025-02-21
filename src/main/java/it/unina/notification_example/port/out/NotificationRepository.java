package it.unina.notification_example.port.out;

import it.unina.notification_example.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, String> {
    List<Notification> findAllByUserId(String userId);
}
