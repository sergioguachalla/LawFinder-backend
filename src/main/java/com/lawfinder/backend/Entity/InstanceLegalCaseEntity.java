package com.lawfinder.backend.Entity;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "INSTANCE_LEGAL_CASE")
public class InstanceLegalCaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INSTANCE_LEGAL_CASE_ID")
    private Long instanceLegalCaseId;

    @OneToOne
    @JoinColumn(name = "AUDIENCE_ID", referencedColumnName = "AUDIENCE_ID", nullable = false)
    private AudienceEntity audience;

    @ManyToOne
    @JoinColumn(name = "INSTANCE_ID", referencedColumnName = "INSTANCE_ID", nullable = false)
    private InstanceEntity instance;

    @ManyToOne
    @JoinColumn(name = "LEGAL_CASE_ID", referencedColumnName = "LEGAL_CASE_ID", nullable = false)
    private LegalCaseEntity legalCase;

    @OneToOne
    @JoinColumn(name = "RESOLUTION_ID", referencedColumnName = "RESOLUTION_ID", nullable = false)
    private ResolutionEntity resolution;

    @Column(name = "START_DATE", nullable = false)
    private Date startDate;

    // Constructor vacío
    public InstanceLegalCaseEntity() {
    }

    // Constructor con todos los atributos
    public InstanceLegalCaseEntity(AudienceEntity audience, InstanceEntity instance, LegalCaseEntity legalCase, ResolutionEntity resolution, Date startDate) {
        this.audience = audience;
        this.instance = instance;
        this.legalCase = legalCase;
        this.resolution = resolution;
        this.startDate = startDate;
    }

    // Getters
    public Long getInstanceLegalCaseId() {
        return instanceLegalCaseId;
    }

    public AudienceEntity getAudience() {
        return audience;
    }

    public InstanceEntity getInstance() {
        return instance;
    }

    public LegalCaseEntity getLegalCase() {
        return legalCase;
    }

    public ResolutionEntity getResolution() {
        return resolution;
    }

    public Date getStartDate() {
        return startDate;
    }

    // Setters
    public void setInstanceLegalCaseId(Long instanceLegalCaseId) {
        this.instanceLegalCaseId = instanceLegalCaseId;
    }

    public void setAudience(AudienceEntity audience) {
        this.audience = audience;
    }

    public void setInstance(InstanceEntity instance) {
        this.instance = instance;
    }

    public void setLegalCase(LegalCaseEntity legalCase) {
        this.legalCase = legalCase;
    }

    public void setResolution(ResolutionEntity resolution) {
        this.resolution = resolution;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    // toString
    @Override
    public String toString() {
        return "InstanceLegalCaseEntity [instanceLegalCaseId=" + instanceLegalCaseId + ", audience=" + audience + ", instance=" + instance
                + ", legalCase=" + legalCase + ", resolution=" + resolution + ", startDate=" + startDate + "]";
    }
}