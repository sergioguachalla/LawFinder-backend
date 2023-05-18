package com.lawfinder.backend.dto;
import java.util.Date;


/*
 * 
 * HAY QUE CORREGIR unu
 * 
 * 
 * 
 */
public class JurisprudenceDto {
    private Long idJurisprudence;
    private Date sentenceDate;
    private String summary;
    private String status;
    private Integer provinceId;
    private Integer subcategoryId;
    private Integer fileId;
    private String txUser;
    private String txHost;
    private Date txDate;


    public JurisprudenceDto() {}

    public JurisprudenceDto(Long idJurisprudence, Date sentenceDate, String summary, String status, Integer provinceId, Integer subcategoryId, Integer fileId, String txUser, String txHost, Date txDate) {
        this.idJurisprudence = idJurisprudence;
        this.sentenceDate = sentenceDate;
        this.summary = summary;
        this.status = status;
        this.provinceId = provinceId;
        this.subcategoryId = subcategoryId;
        this.fileId = fileId;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }


    //getters

    public Long getIdJurisprudence() {
        return idJurisprudence;
    }

    public Date getSentenceDate() {
        return sentenceDate;
    }

    public String getSummary() {
        return summary;
    }

    public String getStatus() {
        return status;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public Integer getSubcategoryId() {
        return subcategoryId;
    }

    public Integer getFileId() {
        return fileId;
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

    //setters

    public void setIdJurisprudence(Long idJurisprudence) {
        this.idJurisprudence = idJurisprudence;
    }

    public void setSentenceDate(Date sentenceDate) {
        this.sentenceDate = sentenceDate;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public void setSubcategoryId(Integer subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
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


    
}
