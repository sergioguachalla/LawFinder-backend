package com.lawfinder.backend.dto;

public class ActorDto {

    private Long actorId;
    private Integer userId;
    private Integer legalCaseId;
    private boolean status;

    public ActorDto() {
    }

    public ActorDto(Long actorId, Integer userId, Integer legalCaseId, boolean status) {
        this.actorId = actorId;
        this.userId = userId;
        this.legalCaseId = legalCaseId;
        this.status = status;
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
}
