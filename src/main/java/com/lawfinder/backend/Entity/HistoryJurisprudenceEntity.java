package com.lawfinder.backend.Entity;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name = "H_JURISPRUDENCE")
public class HistoryJurisprudenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "H_JURISPRUDENCE_ID")
    private Long id;

    @Column(name = "SENTENCEDATE", nullable = false)
    private Date sentenceDate;

    @Column(name = "JURISPRUDENCE", nullable = false)
    private byte[] jurisprudence;

    @Column(name = "SUMMARY", length = 2000, nullable = false)
    private String summary;

    @Column(name = "PROV_ID", nullable = false)
    private Integer provId;

    @Column(name = "SUBCATEGORY_ID", nullable = false)
    private Integer subcategoryId;

    @Column(name = "H_JUDGE_ID", nullable = false)
    private Integer hJudgeId;

    // Constructor vacío
    public HistoryJurisprudenceEntity() {
    }

    // Constructor
    public HistoryJurisprudenceEntity(Long id ,Date sentenceDate, byte[] jurisprudence, String summary, Integer provId, Integer subcategoryId, Integer hJudgeId) {
        
        this.id = id;
        this.sentenceDate = sentenceDate;
        this.jurisprudence = jurisprudence;
        this.summary = summary;
        this.provId = provId;
        this.subcategoryId = subcategoryId;
        this.hJudgeId = hJudgeId;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getSentenceDate() {
        return sentenceDate;
    }

    public void setSentenceDate(Date sentenceDate) {
        this.sentenceDate = sentenceDate;
    }

    public byte[] getJurisprudence() {
        return jurisprudence;
    }

    public void setJurisprudence(byte[] jurisprudence) {
        this.jurisprudence = jurisprudence;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getProvId() {
        return provId;
    }

    public void setProvId(Integer provId) {
        this.provId = provId;
    }

    public Integer getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Integer subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public Integer getHJudgeId() {
        return hJudgeId;
    }

    public void sethJudgeId(Integer hJudgeId) {
        this.hJudgeId = hJudgeId;
    }

    @Override
    public String toString() {
        return "HistoryJurisprudenceEntity{" +
                "id=" + id +
                ", sentenceDate=" + sentenceDate +
                ", jurisprudence=" + Arrays.toString(jurisprudence) +
                ", summary='" + summary + '\'' +
                ", provId=" + provId +
                ", subcategoryId=" + subcategoryId +
                ", hJudgeId=" + hJudgeId +
                '}';
    }
}

