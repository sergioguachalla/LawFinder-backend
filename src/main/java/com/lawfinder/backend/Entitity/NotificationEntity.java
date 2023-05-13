package com.lawfinder.backend.Entitity;
import jakarta.persistence.*;

@Entity
@Table(name = "NOTIFICATION")
public class NotificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NOTIFICATION_ID")
    private Long notificationId;

    
    
    
}
