package it.unina.notification_example.adapter.in;

import it.unina.notification_example.model.Notification;
import it.unina.notification_example.port.in.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/{user-id}")
    public ResponseEntity<List<Notification>> getNotifications(@PathVariable("user-id") String userId) {
        var notifications = notificationService.getNotifications(userId);
        return ResponseEntity.ok().body(notifications);
    }


}
