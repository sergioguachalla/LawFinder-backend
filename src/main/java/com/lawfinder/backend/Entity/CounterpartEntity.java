package com.lawfinder.backend.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "COUNTERPART")
public class CounterpartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COUNTERPART_ID")
    private Long counterpartId;

    @Column(name = "COUNTERPART_NAME", length = 2000, nullable = false)
    private String counterpartName;

    @ManyToOne
    @JoinColumn(name = "LEGAL_CASE_ID", nullable = false)
    private LegalCaseEntity legalCaseId;
    // Constructor
    public CounterpartEntity() {}

    // Constructor con todos los atributos
    public CounterpartEntity(String counterpartName, LegalCaseEntity legalCaseId) {
        this.counterpartName = counterpartName;
        this.legalCaseId = legalCaseId;
    }

    // Getters y Setters
    public Long getCounterpartId() {
        return counterpartId;
    }

    public void setCounterpartId(Long counterpartId) {
        this.counterpartId = counterpartId;
    }

    public String getCounterpartName() {
        return counterpartName;
    }

    public void setCounterpartName(String counterpartName) {
        this.counterpartName = counterpartName;
    }

    public LegalCaseEntity getLegalCaseId() {
        return legalCaseId;
    }

    public void setLegalCaseId(LegalCaseEntity legalCaseId) {
        this.legalCaseId = legalCaseId;
    }
}
