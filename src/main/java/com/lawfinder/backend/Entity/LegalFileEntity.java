package com.lawfinder.backend.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LEGAL_FILE")
public class LegalFileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LEGAL_FILE_ID")
    private int legalFileId;

    @Column(name = "RESOLUTION_DATE")
    private Date resolutionDate;

    @Column(name = "TX_USER")
    private String txUser;

    @Column(name = "TX_HOST")
    private String txHost;

    @Column(name = "TX_DATE")
    private Date txDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COURT_ID", referencedColumnName = "COURT_ID")
    private CourtEntity courtId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FILE_ID", referencedColumnName = "FILE_ID")
    private FileEntity fileFileId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INSTANCE_LEGAL_CASE_ID", referencedColumnName = "INSTANCE_LEGAL_CASE_ID")
    private InstanceLegalCaseEntity instanceLegalCaseId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LEGAL_FILE_TYPE_ID", referencedColumnName = "LEGAL_FILE_TYPE_ID")
    private LegalFileTypeEntity legalFileTypeId;

    @Column(name = "SUMMARY")
    private String summary;

    // Constructores, getters y setters

    public LegalFileEntity() {
    }

    public LegalFileEntity(Date resolutionDate, String txUser, String txHost, Date txDate, CourtEntity courtId,
                           FileEntity fileFileId, InstanceLegalCaseEntity instanceLegalCaseId, LegalFileTypeEntity legalFileTypeId, String summary){
        this.resolutionDate = resolutionDate;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
        this.courtId = courtId;
        this.fileFileId = fileFileId;
        this.instanceLegalCaseId = instanceLegalCaseId;
        this.legalFileTypeId = legalFileTypeId;
        this.summary = summary;
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

    public CourtEntity getCourtId() {
        return courtId;
    }

    public void setCourtId(CourtEntity courtId) {
        this.courtId = courtId;
    }

    public FileEntity getFileId() {
        return fileFileId;
    }

    public void setFileId(FileEntity fileFileId) {
        this.fileFileId = fileFileId;
    }

    public InstanceLegalCaseEntity getInstanceLegalCaseId() {
        return instanceLegalCaseId;
    }

    public void setInstanceLegalCaseId(InstanceLegalCaseEntity instanceLegalCaseId) {
        this.instanceLegalCaseId = instanceLegalCaseId;
    }

    public LegalFileTypeEntity getLegalFileTypeId() {
        return legalFileTypeId;
    }

    public void setLegalFileTypeId(LegalFileTypeEntity legalFileTypeId) {
        this.legalFileTypeId = legalFileTypeId;
    }

    public FileEntity getFileFileId() {
        return fileFileId;
    }

    public void setFileFileId(FileEntity fileFileId) {
        this.fileFileId = fileFileId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "LegalFileEntity{" +
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
