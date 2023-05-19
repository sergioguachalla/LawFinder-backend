package com.lawfinder.backend.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "H_FEEDBACK")
public class HistoryFeedbackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "H_FEEDBACK_ID")
    private Long hFeedbackId;

    @Column(name = "FEEDBACK_ID", nullable = false)
    private int feedbackId;

    @Column(name = "CONTENT", nullable = false, columnDefinition = "text")
    private String content;

    @Column(name = "USER_ID", nullable = false)
    private int userId;

    @Column(name = "TX_USER", nullable = false, length = 100)
    private String txUser;

    @Column(name = "TX_HOST", nullable = false, length = 100)
    private String txHost;

    @Column(name = "TX_DATE", nullable = false, length = 100)
    private Date txDate;

    // Constructor
    public HistoryFeedbackEntity() {}

    // Constructor con todos los atributos

    public HistoryFeedbackEntity(Long hFeedbackId,int feedbackId, String content, int userId, String txUser, String txHost, Date txDate) {
        
        this.hFeedbackId = hFeedbackId;
        this.feedbackId = feedbackId;
        this.content = content;
        this.userId = userId;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    // Getters y setters

    public Long getHFeedbackId() {
        return hFeedbackId;
    }

    public void setHFeedbackId(Long hFeedbackId) {
        this.hFeedbackId = hFeedbackId;
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    //toString

    @Override
    public String toString() {
        return "HistoryFeedbackEntity{" +
                "hFeedbackId=" + hFeedbackId +
                ", feedbackId=" + feedbackId +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", txUser='" + txUser + '\'' +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                '}';
    }
}
