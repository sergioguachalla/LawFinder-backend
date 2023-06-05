package com.lawfinder.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "RESOLUTION_TYPE")
public class ResolutionTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESOLUTION_TYPE_ID")
    private Long resolutionTypeId;

    @Column(name = "RESOLUTION_TYPE", nullable = false, length = 100)
    private String resolutionType;

    // Constructor vacío
    public ResolutionTypeEntity() {
    }

    // Constructor con todos los atributos
    public ResolutionTypeEntity(String resolutionType) {
        this.resolutionType = resolutionType;
    }

    // Getters
    public Long getResolutionTypeId() {
        return resolutionTypeId;
    }

    public String getResolutionType() {
        return resolutionType;
    }

    // Setters
    public void setResolutionTypeId(Long resolutionTypeId) {
        this.resolutionTypeId = resolutionTypeId;
    }

    public void setResolutionType(String resolutionType) {
        this.resolutionType = resolutionType;
    }

    // toString
    @Override
    public String toString() {
        return "ResolutionTypeEntity [resolutionTypeId=" + resolutionTypeId + ", resolutionType=" + resolutionType + "]";
    }
}