package com.lawfinder.backend.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "JURISPRUDENCE")
public class JurisprudenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JURISPRUDENCE_ID")
    private Integer id;

    @Column(name = "SENTENCEDATE", nullable = false)
    private Date sentenceDate;

    @Column(name = "SUMMARY", length = 2000, nullable = false)
    private String summary;

    @Column(name = "STATUS")
    private boolean status;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "PROVINCE_ID", referencedColumnName = "PROVINCE_ID")
    private ProvinceEntity provinceId;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBCATEGORY_ID", referencedColumnName = "SUBCATEGORY_ID")
    private SubCategoryEntity subcategoryId;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "FILE_ID", referencedColumnName = "FILE_ID")
    private FileEntity fileId;

    @Column(name = "TX_USER", length = 100, nullable = false)
    private String txUser;

    @Column(name = "TX_HOST", length = 100, nullable = false)
    private String txHost;

    @Column(name = "TX_DATE", nullable = false)
    private Date txDate;


    public JurisprudenceEntity(){
    }
    public JurisprudenceEntity(Integer id, Date sentenceDate, Boolean status, String summary, ProvinceEntity provId, 
            SubCategoryEntity subcategoryId, FileEntity fileId, String txUser, String txHost, Date txDate) {
        this.id = id;
        this.sentenceDate = sentenceDate;
        this.summary = summary;
        this.status = status;
        this.provinceId = provId;
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public ProvinceEntity getProvId() {
        return provinceId;
    }

    public void setProvId(ProvinceEntity provId) {
        this.provinceId = provId;
    }

    public SubCategoryEntity getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(SubCategoryEntity subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public FileEntity getFileId() {
        return fileId;
    }

    public void setFileId(FileEntity fileId) {
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    //toString 

    @Override
    public String toString() {
        return "JurisprudenceEntity{" +
                "id=" + id +
                ", sentenceDate=" + sentenceDate +
                ", summary='" + summary + '\'' +
                ", status=" + status +
                ", provinceId=" + provinceId +
                ", subcategoryId=" + subcategoryId +
                ", fileId=" + fileId +
                ", txUser='" + txUser + '\'' +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                '}';
    }

}
