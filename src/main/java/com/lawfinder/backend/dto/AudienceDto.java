package com.lawfinder.backend.dto;

import java.time.LocalDateTime;

public class AudienceDto {
    private Long audienceId;
    private LocalDateTime audienceDate;
    private String description;
    private String link;
    private String address;
    private Long instanceLegalCaseId;

    // Constructores
    public AudienceDto() {
    }

    public AudienceDto(Long audienceId, LocalDateTime audienceDate, String description, String link, String address, Long instanceLegalCaseId) {
        this.audienceId = audienceId;
        this.audienceDate = audienceDate;
        this.description = description;
        this.link = link;
        this.address = address;
        this.instanceLegalCaseId = instanceLegalCaseId;
    }

    // Getters y Setters
    public Long getAudienceId() {
        return audienceId;
    }

    public void setAudienceId(Long audienceId) {
        this.audienceId = audienceId;
    }

    public LocalDateTime getAudienceDate() {
        return audienceDate;
    }

    public void setAudienceDate(LocalDateTime audienceDate) {
        this.audienceDate = audienceDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getInstanceLegalCaseId() {
        return instanceLegalCaseId;
    }

    public void setInstanceLegalCaseId(Long instanceLegalCaseId) {
        this.instanceLegalCaseId = instanceLegalCaseId;
    }
}