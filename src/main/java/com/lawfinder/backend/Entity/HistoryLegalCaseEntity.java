package com.lawfinder.backend.Entity;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "H_LEGAL_CASE")
public class HistoryLegalCaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "H_LEGAL_CASE_ID")
    private Long hLegalCaseId;

    @Column(name = "ID_LEGAL_CASE", nullable = false)
    private int idLegalCase;

    @Column(name = "TITLE", nullable = false, length = 2000)
    private String title;

    @Column(name = "START_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "SUMMARY", nullable = false, columnDefinition = "text")
    private String summary;

    @Column(name = "STATUS", nullable = false, length = 100)
    private String status;

    @Column(name = "FIRST_INSTANCE_COURT", nullable = false, length = 100)
    private String firstInstanceCourt;

    @Column(name = "SECOND_INSTANCE_COURT", nullable = false, length = 100)
    private String secondInstanceCourt;

    @Column(name = "THIRD_INSTANCE_COURT", nullable = false, length = 100)
    private String thirdInstanceCourt;

    @Column(name = "USER_ID", nullable = false)
    private int userId;

    @Column(name = "TX_USER", nullable = false, length = 100)
    private String txUser;

    @Column(name = "TX_HOST", nullable = false, length = 100)
    private String txHost;

    @Column(name = "TX_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date txDate;

    // Constructor
    public HistoryLegalCaseEntity() {
    }

    // Constructor con todos los atributos
    public HistoryLegalCaseEntity(int idLegalCase, String title, Date startDate, String summary, String status,
            String firstInstanceCourt, String secondInstanceCourt, String thirdInstanceCourt, int userId, String txUser,
            String txHost, Date txDate) {
        this.idLegalCase = idLegalCase;
        this.title = title;
        this.startDate = startDate;
        this.summary = summary;
        this.status = status;
        this.firstInstanceCourt = firstInstanceCourt;
        this.secondInstanceCourt = secondInstanceCourt;
        this.thirdInstanceCourt = thirdInstanceCourt;
        this.userId = userId;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    // Getters y setters

    public Long getHLegalCaseId() {
        return hLegalCaseId;
    }

    public void setHLegalCaseId(Long hLegalCaseId) {
        this.hLegalCaseId = hLegalCaseId;
    }

    public int getIdLegalCase() {
        return idLegalCase;
    }

    public void setIdLegalCase(int idLegalCase) {
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    // toString

    @Override
    public String toString() {
        return "HistoryLegalCaseEntity{" + "hLegalCaseId=" + hLegalCaseId + ", idLegalCase=" + idLegalCase + ", title='"
                + title + '\'' + ", startDate=" + startDate + ", summary='" + summary + '\'' + ", status='" + status
                + '\'' + ", firstInstanceCourt='" + firstInstanceCourt + '\'' + ", secondInstanceCourt='"
                + secondInstanceCourt + '\'' + ", thirdInstanceCourt='" + thirdInstanceCourt + '\'' + ", userId="
                + userId + ", txUser='" + txUser + '\'' + ", txHost='" + txHost + '\'' + ", txDate=" + txDate + '}';
    }
}
