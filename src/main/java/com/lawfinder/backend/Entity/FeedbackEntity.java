package com.lawfinder.backend.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "FEEDBACK")
public class FeedbackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FEEDBACK_ID")
    private Long feedbackId;

    @Column(name = "CONTENT", nullable = false, columnDefinition = "text")
    private String content;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserEntity userId;



    @Column(name = "TX_USER", nullable = false, length = 100)
    private String txUser;

    @Column(name = "TX_HOST", nullable = false, length = 100)
    private String txHost;

    @Column(name = "TX_DATE", nullable = false, length = 100)
    private String txDate;

    // Constructor
    public FeedbackEntity() {
    }

    // Constructor con todos los atributos
    public FeedbackEntity(String content, UserEntity userId, String txUser, String txHost, String txDate) {
        this.content = content;
        this.userId = userId;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    // Getters y setters

    public Long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
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

    public String getTxDate() {
        return txDate;
    }

    public void setTxDate(String txDate) {
        this.txDate = txDate;
    }
}
