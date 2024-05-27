package com.lawfinder.backend.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "SECURITY_LOG")
public class SecurityLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LOG_ID")
    private Long logId;

    @Column(name = "USER_LOG")
    private String userLog;

    @Column(name = "DATE", nullable = false)
    private LocalDateTime date;

    @Column(name = "HOST")
    private String host;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private LogCategoryEntity category;


    public SecurityLogEntity() {}

    public SecurityLogEntity(Long logId, String userLog, LocalDateTime date, String host, String description, LogCategoryEntity category) {
        this.logId = logId;
        this.userLog = userLog;
        this.date = date;
        this.host = host;
        this.description = description;
        this.category = category;
    }

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getUserLog() {
        return userLog;
    }

    public void setUserLog(String userLog) {
        this.userLog = userLog;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LogCategoryEntity getCategory() {
        return category;
    }

    public void setCategory(LogCategoryEntity category) {
        this.category = category;
    }


    @Override
    public String toString() {
        return "SecurityLogEntity{" +
                "logId=" + logId +
                ", userLog='" + userLog + '\'' +
                ", date=" + date +
                ", host='" + host + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }
}
