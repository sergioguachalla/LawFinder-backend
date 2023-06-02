package com.lawfinder.backend.Entity;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RESOLUTION")
public class ResolutionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESOLUTION_ID")
    private Long resolutionId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COURT_ID", referencedColumnName = "COURT_ID", nullable = false)
    private CourtEntity court;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESOLUTION_TYPE_ID", referencedColumnName = "RESOLUTION_TYPE_ID", nullable = false)
    private ResolutionTypeEntity resolutionType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FILE_ID", referencedColumnName = "FILE_ID", nullable = false)
    private FileEntity file;

    @Column(name = "RESOLUTION_NUMBER", nullable = false)
    private int resolutionNumber;

    @Column(name = "RESOLUTION_DATE", nullable = false)
    private Date resolutionDate;

    @Column(name = "TX_USER", nullable = false, length = 100)
    private String txUser;

    @Column(name = "TX_HOST", nullable = false, length = 100)
    private String txHost;

    @Column(name = "TX_DATE", nullable = false)
    private Date txDate;

    // Constructor vacío
    public ResolutionEntity() {
    }

    // Constructor con todos los atributos
    public ResolutionEntity(CourtEntity court, ResolutionTypeEntity resolutionType, FileEntity file, int resolutionNumber, Date resolutionDate, String txUser, String txHost, Date txDate) {
        this.court = court;
        this.resolutionType = resolutionType;
        this.file = file;
        this.resolutionNumber = resolutionNumber;
        this.resolutionDate = resolutionDate;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    // Getters
    public Long getResolutionId() {
        return resolutionId;
    }

    public CourtEntity getCourt() {
        return court;
    }

    public ResolutionTypeEntity getResolutionType() {
        return resolutionType;
    }

    public FileEntity getFile() {
        return file;
    }

    public int getResolutionNumber() {
        return resolutionNumber;
    }

    public Date getResolutionDate() {
        return resolutionDate;
    }

    public String getTxUser() {
        return txUser;
    }

    public String getTxHost() {
        return txHost;
    }

    public Date getTxDate() {
        return txDate;
    }

    // Setters
    public void setResolutionId(Long resolutionId) {
        this.resolutionId = resolutionId;
    }

    public void setCourt(CourtEntity court) {
        this.court = court;
    }

    public void setResolutionType(ResolutionTypeEntity resolutionType) {
        this.resolutionType = resolutionType;
    }

    public void setFile(FileEntity file) {
        this.file = file;
    }

    public void setResolutionNumber(int resolutionNumber) {
        this.resolutionNumber = resolutionNumber;
    }

    public void setResolutionDate(Date resolutionDate) {
        this.resolutionDate = resolutionDate;
    }

    public void setTxUser(String txUser) {
        this.txUser = txUser;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }

    // toString
    @Override
    public String toString() {
        return "ResolutionEntity [resolutionId=" + resolutionId + ", court=" + court + ", resolutionType=" + resolutionType
                + ", file=" + file + ", resolutionNumber=" + resolutionNumber + ", resolutionDate=" + resolutionDate
                + ", txUser=" + txUser + ", txHost=" + txHost + ", txDate=" + txDate + "]";
    }
}