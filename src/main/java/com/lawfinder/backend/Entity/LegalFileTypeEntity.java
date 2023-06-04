package com.lawfinder.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "LEGAL_FILE_TYPE")
public class LegalFileTypeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LEGAL_FILE_TYPE_ID")
    private long legalFileTypeId;

    @Column(name = "FILE_NAME")
    private String name;

    // Constructores, getters y setters

    public LegalFileTypeEntity() {
    }

    // Constructor con todos los atributos



    public LegalFileTypeEntity(Long legalFileTypeId  ,String name) {
        this.name = name;
        this.legalFileTypeId = legalFileTypeId;
    }

    public long getLegalFileTypeId() {
        return legalFileTypeId;
    }

    public void setLegalFileTypeId(long legalFileTypeId) {
        this.legalFileTypeId = legalFileTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
