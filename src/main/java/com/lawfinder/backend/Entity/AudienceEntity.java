package com.lawfinder.backend.Entity;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "AUDIENCE")
public class AudienceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUDIENCE_ID")
    private Long audienceId;

    @Column(name = "AUDIENCE_DATE", nullable = false)
    private Date audienceDate;

    @Column(name = "DESCRIPTION", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "VERDICT", nullable = false, columnDefinition = "TEXT")
    private String verdict;

    @OneToOne
    @JoinColumn(name = "INSTANCE_LEGAL_CASE_ID", nullable = false)
    private InstanceLegalCaseEntity instanceLegalCase;


    // Constructor vacío
    public AudienceEntity() {
    }

    // Constructor con todos los atributos
    public AudienceEntity(Date audienceDate, String description, String verdict, InstanceLegalCaseEntity instanceLegalCase) {
        this.audienceDate = audienceDate;
        this.description = description;
        this.verdict = verdict;
        this.instanceLegalCase = instanceLegalCase;
    }

    // Getters
    public Long getAudienceId() {
        return audienceId;
    }

    public Date getAudienceDate() {
        return audienceDate;
    }

    public String getDescription() {
        return description;
    }

    public String getVerdict() {
        return verdict;
    }

    // Setters
    public void setAudienceId(Long audienceId) {
        this.audienceId = audienceId;
    }

    public void setAudienceDate(Date audienceDate) {
        this.audienceDate = audienceDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVerdict(String verdict) {
        this.verdict = verdict;
    }

    // toString
    @Override
    public String toString() {
        return "AudienceEntity [audienceId=" + audienceId + ", audienceDate=" + audienceDate + ", description=" + description
                + ", verdict=" + verdict + "]";
    }
}
