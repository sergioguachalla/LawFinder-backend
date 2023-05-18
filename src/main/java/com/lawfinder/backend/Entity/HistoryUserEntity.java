package com.lawfinder.backend.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "H_SE_USER")
public class HistoryUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "H_USER_ID")
    private Long hUserId;

    @Column(name = "USER_ID", nullable = false)
    private int userId;

    @Column(name = "USERNAME", nullable = false, length = 100)
    private String username;

    @Column(name = "USERLASTNAME", nullable = false, length = 100)
    private String userLastname;

    @Column(name = "SECRET", nullable = false, length = 60)
    private String secret;

    @Column(name = "STATUS", nullable = false)
    private boolean status;

    @Column(name = "AUD_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audDate;

    @Column(name = "AUD_HOST", nullable = false, length = 60)
    private String audHost;

    @Column(name = "AUD_USER", nullable = false, length = 60)
    private String audUser;

    @Column(name = "TX_USER", nullable = false, length = 100)
    private String txUser;

    @Column(name = "TX_HOST", nullable = false, length = 100)
    private String txHost;

    @Column(name = "TX_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date txDate;

    // Constructor
    public HistoryUserEntity() {
    }

    // Constructor con todos los atributos

    public HistoryUserEntity(int userId, String username, String userLastname, String secret, boolean status, Date audDate, String audHost, String audUser, String txUser, String txHost, Date txDate) {
        this.userId = userId;
        this.username = username;
        this.userLastname = userLastname;
        this.secret = secret;
        this.status = status;
        this.audDate = audDate;
        this.audHost = audHost;
        this.audUser = audUser;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    // Getters y setters

    public Long getHUserId() {
        return hUserId;
    }

    public void setHUserId(Long hUserId) {
        this.hUserId = hUserId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserLastname() {
        return userLastname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getAudDate() {
        return audDate;
    }

    public void setAudDate(Date audDate) {
        this.audDate = audDate;
    }

    public String getAudHost() {
        return audHost;
    }

    public void setAudHost(String audHost) {
        this.audHost = audHost;
    }

    public String getAudUser() {
        return audUser;
    }

    public void setAudUser(String audUser) {
        this.audUser = audUser;
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

    //toString

    @Override
    public String toString() {
        return "HistoryUserEntity{" +
                "hUserId=" + hUserId +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", userLastname='" + userLastname + '\'' +
                ", secret='" + secret + '\'' +
                ", status=" + status +
                ", audDate=" + audDate +
                ", audHost='" + audHost + '\'' +
                ", audUser='" + audUser + '\'' +
                ", txUser='" + txUser + '\'' +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                '}';
    }
}
