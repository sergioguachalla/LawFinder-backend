package com.lawfinder.backend.dto;

import java.time.LocalDateTime;

public class ApplicationLogsDto {
    private Long logId;
    private String username;
    private LocalDateTime logDate;
    private String host;
    private String description;
    private String category;
    private String level;

    public ApplicationLogsDto() {
    }

    public ApplicationLogsDto(Long logId, String username, LocalDateTime logDate, String host, String description, String category, String level) {

        this.logId = logId;
        this.username = username;
        this.logDate = logDate;
        this.host = host;
        this.description = description;
        this.category = category;
        this.level = level;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }


    @Override
    public String toString() {
        return "ApplicationLogsDto{" +
                "logId=" + logId +
                ", username='" + username + '\'' +
                ", logDate=" + logDate +
                ", host='" + host + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
