package com.lawfinder.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CONTENT_NOTIFICATION")

public class ContentNotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONTENT_NOTIFICATION_ID")
    private Long contentNotificationId;

    @Column(name = "CONTENT", length = 2000, nullable = false)
    private String content;

    // Constructor vacio
    public ContentNotificationEntity() {
    }

    // Constructor con todos los atributos

    public ContentNotificationEntity(String content) {
        this.content = content;
    }

    // Getters

    public Long getContentNotificationId() {
        return contentNotificationId;
    }

    public String getContent() {
        return content;
    }

    // Setters

    public void setContentNotificationId(Long contentNotificationId) {
        this.contentNotificationId = contentNotificationId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // toString

    @Override
    public String toString() {
        return "ContentNotificationEntity [content=" + content + ", contentNotificationId=" + contentNotificationId
                + "]";
    }

    
}
