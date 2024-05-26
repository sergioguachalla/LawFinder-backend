package com.lawfinder.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "LOG_LEVEL")
public class LogLevelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LEVEL_ID")
    private Long levelId;

    @Column(name = "LEVEL_NAME", nullable = false)
    private String levelName;

    public LogLevelEntity() {
    }

    public LogLevelEntity(Long levelId, String levelName) {
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
        return "LogLevelEntity{" +
                "levelId=" + levelId +
                ", levelName='" + levelName + '\'' +
                '}';
    }
}
