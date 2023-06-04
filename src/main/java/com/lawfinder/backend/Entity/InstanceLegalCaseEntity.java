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

    @ManyToOne
    @JoinColumn(name = "INSTANCE_ID", referencedColumnName = "INSTANCE_ID", nullable = false)
    private InstanceEntity instance;

    @ManyToOne
    @JoinColumn(name = "LEGAL_CASE_ID", referencedColumnName = "LEGAL_CASE_ID", nullable = false)
    private LegalCaseEntity legalCase;



    @Column(name = "START_DATE", nullable = false)
    private Date startDate;

    // Constructor vacío
    public InstanceLegalCaseEntity() {
    }

    // Constructor con todos los atributos
    public InstanceLegalCaseEntity( InstanceEntity instance, LegalCaseEntity legalCase, ResolutionEntity resolution, Date startDate) {
        this.instance = instance;
        this.legalCase = legalCase;
        this.startDate = startDate;
    }

    // Getters
    public Long getInstanceLegalCaseId() {
        return instanceLegalCaseId;
    }


    public InstanceEntity getInstance() {
        return instance;
    }

    public LegalCaseEntity getLegalCase() {
        return legalCase;
    }



    public Date getStartDate() {
        return startDate;
    }

    // Setters
    public void setInstanceLegalCaseId(Long instanceLegalCaseId) {
        this.instanceLegalCaseId = instanceLegalCaseId;
    }


    public void setInstance(InstanceEntity instance) {
        this.instance = instance;
    }

    public void setLegalCase(LegalCaseEntity legalCase) {
        this.legalCase = legalCase;
    }


    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    // toString
    @Override
    public String toString() {
        return "InstanceLegalCaseEntity [instanceLegalCaseId=" + instanceLegalCaseId +  ", instance=" + instance
                + ", legalCase=" + legalCase +
                ", startDate=" + startDate + "]";
    }
}