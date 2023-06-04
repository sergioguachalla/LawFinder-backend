package com.lawfinder.backend.dto;

import java.util.Date;

public class InstanceLegalCaseDto {
    private Long instanceLegalCaseId;
    private Long audienceId;
    private Long instanceId;
    private Long legalCaseId;
    private Long resolutionId;
    private Date startDate;

    // Constructor vacío
    public InstanceLegalCaseDto() {
    }

    // Constructor con todos los atributos
    public InstanceLegalCaseDto(Long instanceLegalCaseId, Long audienceId, Long instanceId, Long legalCaseId, Long resolutionId, Date startDate) {
        this.instanceLegalCaseId = instanceLegalCaseId;
        this.audienceId = audienceId;
        this.instanceId = instanceId;
        this.legalCaseId = legalCaseId;
        this.resolutionId = resolutionId;
        this.startDate = startDate;
    }

    // Getters y Setters

    public Long getInstanceLegalCaseId() {
        return instanceLegalCaseId;
    }

    public void setInstanceLegalCaseId(Long instanceLegalCaseId) {
        this.instanceLegalCaseId = instanceLegalCaseId;
    }

    public Long getAudienceId() {
        return audienceId;
    }

    public void setAudienceId(Long audienceId) {
        this.audienceId = audienceId;
    }

    public Long getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(Long instanceId) {
        this.instanceId = instanceId;
    }

    public Long getLegalCaseId() {
        return legalCaseId;
    }

    public void setLegalCaseId(Long legalCaseId) {
        this.legalCaseId = legalCaseId;
    }

    public Long getResolutionId() {
        return resolutionId;
    }

    public void setResolutionId(Long resolutionId) {
        this.resolutionId = resolutionId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    // toString
    @Override
    public String toString() {
        return "InstanceLegalCaseDTO [instanceLegalCaseId=" + instanceLegalCaseId + ", audienceId=" + audienceId + ", instanceId=" + instanceId
                + ", legalCaseId=" + legalCaseId + ", resolutionId=" + resolutionId + ", startDate=" + startDate + "]";
    }
}

