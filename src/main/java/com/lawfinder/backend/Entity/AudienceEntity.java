package com.lawfinder.backend.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "AUDIENCE")
public class AudienceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUDIENCE_ID")
    private Long audienceId;


    @Column(name = "AUDIENCE_DATE", nullable = false)
    private LocalDateTime audienceDate;

    @Column(name = "DESCRIPTION", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "LINK", columnDefinition = "TEXT")
    private String link;

    @Column(name = "ADDRESS", nullable = false, columnDefinition = "TEXT")
    private String address;

    @ManyToOne
    @JoinColumn(name = "LEGAL_CASE_ID", nullable = false)
    private LegalCaseEntity legalCaseId;


    // Constructor vacío
    public AudienceEntity() {
    }

    // Constructor con todos los atributos
    public AudienceEntity(LocalDateTime audienceDate, String description, String link, String address, LegalCaseEntity legalCaseEntity) {
        this.audienceDate = audienceDate;
        this.description = description;
        this.link = link;
        this.address = address;
        this.legalCaseId = legalCaseEntity;
    }

    // Getters
    public Long getAudienceId() {
        return audienceId;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }

    public String getAddress() {
        return address;
    }

    public LegalCaseEntity getLegalCaseId() {
        return
                legalCaseId;
    }

    public LocalDateTime getAudienceDate() {
        return audienceDate;
    }

    public void setAudienceDate(LocalDateTime audienceDate) {
        this.audienceDate = audienceDate;
    }
    // Setters
    public void setAudienceId(Long audienceId) {
        this.audienceId = audienceId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLegalCaseId(LegalCaseEntity legalCaseId) {
        this.legalCaseId = legalCaseId;
    }

    // toString
    @Override
    public String toString() {
        return "AudienceEntity [audienceId=" + audienceId + ", audienceDate=" + audienceDate + ", description=" + description
                + ", link=" + link + ", address=" + address + "]";
    }
}
