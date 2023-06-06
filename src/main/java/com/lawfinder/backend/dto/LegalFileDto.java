package com.lawfinder.backend.dto;

import com.lawfinder.backend.Entity.CourtEntity;
import com.lawfinder.backend.Entity.FileEntity;
import com.lawfinder.backend.Entity.InstanceLegalCaseEntity;
import com.lawfinder.backend.Entity.LegalFileTypeEntity;

import java.util.Date;

public class LegalFileDto {
    private int legalFileId;
    private Date resolutionDate;
    private String txUser;
    private String txHost;
    private Date txDate;
    private Long courtId;
    private Long fileFileId;
    private Long instanceLegalCaseId;
    private Long legalFileTypeId;

    public LegalFileDto() {
    }

    public LegalFileDto(int legalFileId, Date resolutionDate, String txUser, String txHost, Date txDate, Long courtId, Long fileFileId, Long instanceLegalCaseId, Long legalFileTypeId) {
        this.legalFileId = legalFileId;
        this.resolutionDate = resolutionDate;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
        this.courtId = courtId;
        this.fileFileId = fileFileId;
        this.instanceLegalCaseId = instanceLegalCaseId;
        this.legalFileTypeId = legalFileTypeId;
    }

    public int getLegalFileId() {
        return legalFileId;
    }

    public void setLegalFileId(int legalFileId) {
        this.legalFileId = legalFileId;
    }

    public Date getResolutionDate() {
        return resolutionDate;
    }

    public void setResolutionDate(Date resolutionDate) {
        this.resolutionDate = resolutionDate;
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

    public Long getCourtId() {
        return courtId;
    }

    public void setCourtId(Long courtId) {
        this.courtId = courtId;
    }

    public Long getFileFileId() {
        return fileFileId;
    }

    public void setFileFileId(Long fileFileId) {
        this.fileFileId = fileFileId;
    }

    public Long getInstanceLegalCaseId() {
        return instanceLegalCaseId;
    }

    public void setInstanceLegalCaseId(Long instanceLegalCaseId) {
        this.instanceLegalCaseId = instanceLegalCaseId;
    }

    public Long getLegalFileTypeId() {
        return legalFileTypeId;
    }

    public void setLegalFileTypeId(Long legalFileTypeId) {
        this.legalFileTypeId = legalFileTypeId;
    }

    @Override
    public String toString() {
        return "LegalFileDTO{" +
                "legalFileId=" + legalFileId +
                ", resolutionDate=" + resolutionDate +
                ", txUser='" + txUser + '\'' +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                ", courtId=" + courtId +
                ", fileFileId=" + fileFileId +
                ", instanceLegalCaseId=" + instanceLegalCaseId +
                ", legalFileTypeId=" + legalFileTypeId +
                '}';
    }
}
