package com.lawfinder.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "COURT")
public class CourtEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COURT_ID")
    private Long courtId;

    @Column(name = "COURT_NAME", nullable = false)
    private String courtName;

    // Constructor vacío
    public CourtEntity() {
    }

    // Constructor con todos los atributos
    public CourtEntity(String courtName) {
        this.courtName = courtName;
    }

    // Getters
    public Long getCourtId() {
        return courtId;
    }

    public String getCourtName() {
        return courtName;
    }

    // Setters
    public void setCourtId(Long courtId) {
        this.courtId = courtId;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    // toString
    @Override
    public String toString() {
        return "CourtEntity [courtId=" + courtId + ", courtName=" + courtName + "]";
    }
}