package com.lawfinder.backend.Entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LEGAL_CASE")
public class LegalCaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LEGAL_CASE")
    private Long idLegalCase;

    @Column(name = "TITLE", length = 2000)
    private String title;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "SUMMARY")
    private String summary;

    @Column(name = "STATUS", length = 100)
    private String status;

    @Column(name = "FIRST_INSTANCE_COURT", length = 100)
    private String firstInstanceCourt;

    @Column(name = "SECOND_INSTANCE_COURT", length = 100)
    private String secondInstanceCourt;

    @Column(name = "THIRD_INSTANCE_COURT", length = 100)
    private String thirdInstanceCourt;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private UserEntity user;

    @Column(name = "TX_USER", length = 100)
    private String txUser;

    @Column(name = "TX_HOST", length = 100)
    private String txHost;

    @Column(name = "TX_DATE")
    private Date txDate;

    // Constructor vacio
    public LegalCaseEntity() {}

    // Constructor con todos los atributos

    public LegalCaseEntity(String title, Date startDate, String summary, String status, String firstInstanceCourt, String secondInstanceCourt, String thirdInstanceCourt, UserEntity user, String txUser, String txHost, Date txDate) {
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

    // Getters

    public Long getIdLegalCase() {
        return idLegalCase;
    }

    public String getTitle() {
        return title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getSummary() {
        return summary;
    }

    public String getStatus() {
        return status;
    }

    public String getFirstInstanceCourt() {
        return firstInstanceCourt;
    }

    public String getSecondInstanceCourt() {
        return secondInstanceCourt;
    }

    public String getThirdInstanceCourt() {
        return thirdInstanceCourt;
    }

    public UserEntity getUser() {
        return user;
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

    public void setIdLegalCase(Long idLegalCase) {
        this.idLegalCase = idLegalCase;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setFirstInstanceCourt(String firstInstanceCourt) {
        this.firstInstanceCourt = firstInstanceCourt;
    }

    public void setSecondInstanceCourt(String secondInstanceCourt) {
        this.secondInstanceCourt = secondInstanceCourt;
    }

    public void setThirdInstanceCourt(String thirdInstanceCourt) {
        this.thirdInstanceCourt = thirdInstanceCourt;
    }

    public void setUser(UserEntity user) {
        this.user = user;
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
        return "LegalCaseEntity [firstInstanceCourt=" + firstInstanceCourt + ", idLegalCase=" + idLegalCase
                + ", secondInstanceCourt=" + secondInstanceCourt + ", startDate=" + startDate + ", status=" + status
                + ", summary=" + summary + ", thirdInstanceCourt=" + thirdInstanceCourt + ", title=" + title
                + ", txDate=" + txDate + ", txHost=" + txHost + ", txUser=" + txUser + ", user=" + user + "]";
    }
}
