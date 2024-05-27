package com.lawfinder.backend.dto;

import java.util.Date;

public class ConfidentialCaseDto {
    private Long caseId;
    private String caseName;
    private String caseDescription;
    private String crime;
    private Date startDate;
    private String confidentiality;

    public ConfidentialCaseDto() {
    }

    public ConfidentialCaseDto(Long caseId, String caseName, String caseDescription, String crime, Date startDate, String confidentiality) {
        this.caseId = caseId;
        this.caseName = caseName;
        this.caseDescription = caseDescription;
        this.crime = crime;
        this.startDate = startDate;
        this.confidentiality = confidentiality;
    }


    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getCaseDescription() {
        return caseDescription;
    }

    public void setCaseDescription(String caseDescription) {
        this.caseDescription = caseDescription;
    }

    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getConfidentiality() {
        return confidentiality;
    }

    public void setConfidentiality(String confidentiality) {
        this.confidentiality = confidentiality;
    }
}
