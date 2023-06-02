package com.lawfinder.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "LEGAL_FILE_TYPE")
public class LegalFileTypeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LEGAL_FILE_TYPE_ID")
    private int legalFileTypeId;

    @Column(name = "NAME")
    private int name;

    // Constructores, getters y setters

    public LegalFileTypeEntity() {
    }

    public LegalFileTypeEntity(int name) {
        this.name = name;
    }

    public int getLegalFileTypeId() {
        return legalFileTypeId;
    }

    public void setLegalFileTypeId(int legalFileTypeId) {
        this.legalFileTypeId = legalFileTypeId;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
}
