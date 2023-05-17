package com.lawfinder.backend.dto;

import com.lawfinder.backend.Entity.UserEntity;

import java.util.Date;

public class LegalCaseDto {

    private Long idLegalCase;
    private String title;
    private Date startDate;
    private String summary;
    private String status;
    private String firstInstanceCourt;
    private String secondInstanceCourt;
    private String thirdInstanceCourt;
    private UserEntity user;
    private String txUser;
    private String txHost;
    private Date txDate;

    public LegalCaseDto() {
    }

    public LegalCaseDto(String title, Date startDate, String summary, String status, String firstInstanceCourt, String secondInstanceCourt, String thirdInstanceCourt, UserEntity user, String txUser, String txHost, Date txDate) {
        this.title = title;
        this.startDate = startDate;
        this.summary = summary;
        this.status = status;
        this.firstInstanceCourt = firstInstanceCourt;
        this.secondInstanceCourt = secondInstanceCourt;
        this.thirdInstanceCourt = thirdInstanceCourt;
        this.user = user;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Long getIdLegalCase() {
        return idLegalCase;
    }

    public void setIdLegalCase(Long idLegalCase) {
        this.idLegalCase = idLegalCase;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFirstInstanceCourt() {
        return firstInstanceCourt;
    }

    public void setFirstInstanceCourt(String firstInstanceCourt) {
        this.firstInstanceCourt = firstInstanceCourt;
    }

    public String getSecondInstanceCourt() {
        return secondInstanceCourt;
    }

    public void setSecondInstanceCourt(String secondInstanceCourt) {
        this.secondInstanceCourt = secondInstanceCourt;
    }

    public String getThirdInstanceCourt() {
        return thirdInstanceCourt;
    }

    public void setThirdInstanceCourt(String thirdInstanceCourt) {
        this.thirdInstanceCourt = thirdInstanceCourt;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getTxUser() {
        return txUser;
    }

    public void setTxUser(String txUser) {
        this.txUser = txUser;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }
}

