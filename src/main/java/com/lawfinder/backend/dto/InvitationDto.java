package com.lawfinder.backend.dto;

import java.util.Date;

public class InvitationDto {
    private Long actorId;
    private Integer userId;
    private Integer legalCaseId;
    private boolean status;
    private String title;
    private Date startDate;


    public InvitationDto() {
    }

    public InvitationDto(Long actorId, Integer userId, Integer legalCaseId, boolean status, String title, Date startDate) {
        this.actorId = actorId;
        this.userId = userId;
        this.legalCaseId = legalCaseId;
        this.status = status;
        this.title = title;
        this.startDate = startDate;
    }

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLegalCaseId() {
        return legalCaseId;
    }

    public void setLegalCaseId(Integer legalCaseId) {
        this.legalCaseId = legalCaseId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate(){
        return startDate;
    }

    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }
    
}
