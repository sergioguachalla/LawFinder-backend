package com.lawfinder.backend.dto;

import org.springframework.stereotype.Service;


public class CrimeDto {
    private Long crimeId;
    private String name;
    private int prisonSentence;
    private Long subcategoryId;

    public CrimeDto() {
    }

    public CrimeDto(Long crimeId, String name, int prisonSentence, Long subcategoryId) {
        this.crimeId = crimeId;
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

    public int getPrisonSentence() {
        return prisonSentence;
    }

    public void setPrisonSentence(int prisonSentence) {
        this.prisonSentence = prisonSentence;
    }

    public Long getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Long subcategoryId) {
        this.subcategoryId = subcategoryId;
    }
}
