package com.lawfinder.backend.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "JURISPRUDENCE_FEEDBACK")
public class JurisprudenceFeedbackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JURISPRUDENCE_FEEDBACK_ID")
    private Long jurisprudenceFeedbackId;

    
    @ManyToOne
    @JoinColumn(name = "FEEDBACK_ID", nullable = false)
    private FeedbackEntity feedbackId;

    @ManyToOne
    @JoinColumn(name = "JURISPRUDENCE_ID", nullable = false)
    private JurisprudenceEntity jurisprudenceId;

    @Column(name = "DATE", nullable = false)
    private Date date;

    // Constructor
    public JurisprudenceFeedbackEntity() {
    }

    // Constructor con todos los atributos
    public JurisprudenceFeedbackEntity(FeedbackEntity feedbackId, JurisprudenceEntity jurisprudenceId, Date date) {
        this.feedbackId = feedbackId;
        this.jurisprudenceId = jurisprudenceId;
        this.date = date;
    }

    // Getters y setters

    public Long getJurisprudenceFeedbackId() {
        return jurisprudenceFeedbackId;
    }

    public void setJurisprudenceFeedbackId(Long jurisprudenceFeedbackId) {
        this.jurisprudenceFeedbackId = jurisprudenceFeedbackId;
    }

    public FeedbackEntity getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(FeedbackEntity feedbackId) {
        this.feedbackId = feedbackId;
    }

    public JurisprudenceEntity getJurisprudenceId() {
        return jurisprudenceId;
    }

    public void setJurisprudenceId(JurisprudenceEntity jurisprudenceId) {
        this.jurisprudenceId = jurisprudenceId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    //toString

    @Override
    public String toString() {
        return "JurisprudenceFeedbackEntity{" +
                "jurisprudenceFeedbackId=" + jurisprudenceFeedbackId +
                ", feedbackId=" + feedbackId +
                ", jurisprudenceId=" + jurisprudenceId +
                ", date=" + date +
                '}';
    }
}
