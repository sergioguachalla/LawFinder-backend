package com.lawfinder.backend.Entitity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "JURISPRUDENCE")
public class JurisprudenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JURISPRUDENCE_ID")
    private Integer id;

    @Column(name = "SENTENCE_DATE", nullable = false)
    private Date sentenceDate;

    @Lob
    @Column(name = "JURISPRUDENCE", nullable = false)
    private byte[] jurisprudence;

    @Column(name = "SUMMARY", length = 2000, nullable = false)
    private String summary;

    @Column(name = "PROV_ID", nullable = false)
    private Integer provId;

    @Column(name = "SUBCATEGORY_ID", nullable = false)
    private Integer subcategoryId;

    @Column(name = "FILE_FILE_ID", nullable = false)
    private Integer fileId;

    @Column(name = "TX_USER", length = 100, nullable = false)
    private String txUser;

    @Column(name = "TX_HOST", length = 100, nullable = false)
    private String txHost;

    @Column(name = "TX_DATE", nullable = false)
    private Date txDate;


    public JurisprudenceEntity(){
    }
    public JurisprudenceEntity(Integer id, Date sentenceDate, byte[] jurisprudence, String summary, Integer provId, Integer subcategoryId, Integer fileId, String txUser, String txHost, Date txDate) {
        this.id = id;
        this.sentenceDate = sentenceDate;
        this.jurisprudence = jurisprudence;
        this.summary = summary;
        this.provId = provId;
        this.subcategoryId = subcategoryId;
        this.fileId = fileId;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
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

}
