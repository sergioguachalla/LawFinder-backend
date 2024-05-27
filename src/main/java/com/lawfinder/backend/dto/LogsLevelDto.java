package com.lawfinder.backend.dto;

public class LogsLevelDto {
    private Long levelId;
    private String levelName;

    public LogsLevelDto() {
    }

    public LogsLevelDto(Long levelId, String levelName) {
        this.levelId = levelId;
        this.levelName = levelName;
    }

    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    @Override
    public String toString() {
        return "LogsLevelDto{" +
                "levelId=" + levelId +
                ", levelName='" + levelName + '\'' +
                '}';
    }
}
