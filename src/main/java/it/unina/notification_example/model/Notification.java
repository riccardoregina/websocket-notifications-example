package it.unina.notification_example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String userId;
    private String message;
    private LocalDateTime createdAt;
    private boolean read;

    public Notification() {}

    public Notification(String userId, String message, LocalDateTime createdAt, boolean read) {
        this.userId = userId;
        this.message = message;
        this.createdAt = createdAt;
        this.read = read;
    }
}
