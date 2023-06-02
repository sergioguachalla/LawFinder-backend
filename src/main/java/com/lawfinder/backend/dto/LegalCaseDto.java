package com.lawfinder.backend.dto;

import java.util.Date;

public class LegalCaseDto {

    private Long idLegalCase;
    private int idSubCategory;
    private int idProvince;
    private int userId;
    private String part;
    private String contrapart;
    private String title;
    private Date startDate;
    private String summary;

    public LegalCaseDto() {
    }

    public LegalCaseDto(Long idLegalCase, int idSubCategory, int idProvince, int userId, String part, String contrapart,
                        String title, Date startDate, String summary) {
        this.idLegalCase = idLegalCase;
        this.idSubCategory = idSubCategory;
        this.idProvince = idProvince;
        this.userId = userId;
        this.part = part;
        this.contrapart = contrapart;
        this.title = title;
        this.startDate = startDate;
        this.summary = summary;
    }

    public Long getIdLegalCase() {
        return idLegalCase;
    }

    public void setIdLegalCase(Long idLegalCase) {
        this.idLegalCase = idLegalCase;
    }

    public int getIdSubCategory() {
        return idSubCategory;
    }

    public void setIdSubCategory(int idSubCategory) {
        this.idSubCategory = idSubCategory;
    }

    public int getIdProvince() {
        return idProvince;
    }

    public void setIdProvince(int idProvince) {
        this.idProvince = idProvince;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getContrapart() {
        return contrapart;
    }

    public void setContrapart(String contrapart) {
        this.contrapart = contrapart;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
