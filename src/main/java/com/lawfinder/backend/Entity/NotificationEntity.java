package com.lawfinder.backend.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "NOTIFICATION")
public class NotificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NOTIFICATION_ID")
    private Long notificationId;

    @Column(name = "ISREAD", nullable = false)
    private boolean isRead;

    @ManyToOne
    @JoinColumn(name = "SUBCATEGORY_ID", nullable = false)
    private SubCategoryEntity subCategory;

    @ManyToOne
    @JoinColumn(name = "CONTENT_NOTIFICATION_ID", nullable = false)
    private ContentNotificationEntity contentNotification;

    // Constructor vacio
    public NotificationEntity() {}

    // Constructor con todos los atributos

    public NotificationEntity(boolean isRead, SubCategoryEntity subCategory, ContentNotificationEntity contentNotification) {
        this.isRead = isRead;
        this.subCategory = subCategory;
        this.contentNotification = contentNotification;
    }

    // Getters
    
    public Long getNotificationId() {
        return notificationId;
    }

    public boolean isRead() {
        return isRead;
    }

    public SubCategoryEntity getSubCategory() {
        return subCategory;
    }

    public ContentNotificationEntity getContentNotification() {
        return contentNotification;
    }

    // Setters

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }
    
    public void setRead(boolean isRead) {
        this.isRead = isRead;
    }

    public void setSubCategory(SubCategoryEntity subCategory) {
        this.subCategory = subCategory;
    }
    
    public void setContentNotification(ContentNotificationEntity contentNotification) {
        this.contentNotification = contentNotification;
    }
    
    // toString

    @Override
    public String toString() {
        return "NotificationEntity [contentNotification=" + contentNotification + ", isRead=" + isRead
                + ", notificationId=" + notificationId + ", subCategory=" + subCategory + "]";
    }
}
