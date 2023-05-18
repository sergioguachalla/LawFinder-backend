package com.lawfinder.backend.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "USER_NOTIFICATION")
public class UserNotificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_NOTIFICATION_ID")
    private Long userNotificationId;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "NOTIFICATION_ID", referencedColumnName = "NOTIFICATION_ID")
    private NotificationEntity notification;

    // Constructor
    public UserNotificationEntity() {
    }

    // Constructor con todos los atributos
    public UserNotificationEntity(UserEntity user, NotificationEntity notification) {
        this.user = user;
        this.notification = notification;
    }

    // Getters y setters

    public Long getUserNotificationId() {
        return userNotificationId;
    }

    public void setUserNotificationId(Long userNotificationId) {
        this.userNotificationId = userNotificationId;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public NotificationEntity getNotification() {
        return notification;
    }

    public void setNotification(NotificationEntity notification) {
        this.notification = notification;
    }

    // toString

    @Override
    public String toString() {
        return "UserNotificationEntity{" +
                "userNotificationId=" + userNotificationId +
                ", user=" + user +
                ", notification=" + notification +
                '}';
    }
}