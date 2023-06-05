package com.lawfinder.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CRIME")
public class CrimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CRIME_ID")
    private Long crimeId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRISON_SENTENCE")
    private String prisonSentence;

    @ManyToOne
    @JoinColumn(name = "SUBCATEGORY_ID", referencedColumnName = "SUBCATEGORY_ID")
    private SubCategoryEntity subcategoryId;

    // Constructores, getters y setters

    public CrimeEntity() {
    }

    public CrimeEntity(String name, String prisonSentence, SubCategoryEntity subcategoryId) {
        this.name = name;
        this.prisonSentence = prisonSentence;
        this.subcategoryId = subcategoryId;
    }

    public Long getCrimeId() {
        return crimeId;
    }

    public void setCrimeId(Long crimeId) {
        this.crimeId = crimeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrisonSentence() {
        return prisonSentence;
    }

    public void setPrisonSentence(String prisonSentence) {
        this.prisonSentence = prisonSentence;
    }

    public SubCategoryEntity getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(SubCategoryEntity subcategoryId) {
        this.subcategoryId = subcategoryId;
    }
}
