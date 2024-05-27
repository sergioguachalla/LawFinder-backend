package com.lawfinder.backend.dto;

import java.time.LocalDateTime;

public class SecurityLogsDto {
    private Long logId;
    private String username;
    private LocalDateTime logDate;
    private String host;
    private String description;
    private String category;

    public SecurityLogsDto() {
    }

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getLogDate() {
        return logDate;
    }

    public void setLogDate(LocalDateTime logDate) {
        this.logDate = logDate;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    @Override
    public String toString() {
        return "SecurityLogsDto{" +
                "logId=" + logId +
                ", username='" + username + '\'' +
                ", logDate=" + logDate +
                ", host='" + host + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
