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
    private String name;

    // Constructores, getters y setters

    public LegalFileTypeEntity() {
    }

    // Constructor con todos los atributos



    public LegalFileTypeEntity(int legalFileTypeId  ,String name) {
        this.name = name;
        this.legalFileTypeId = legalFileTypeId;
    }

    public int getLegalFileTypeId() {
        return legalFileTypeId;
    }

    public void setLegalFileTypeId(int legalFileTypeId) {
        this.legalFileTypeId = legalFileTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
