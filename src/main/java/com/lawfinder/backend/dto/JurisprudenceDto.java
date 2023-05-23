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
    private Boolean status;
    private ProvinceDto provinceId;
    private SubCategoryDto subcategoryId;
    private FileDto fileId;
    private String txUser;
    private String txHost;
    private Date txDate;


    public JurisprudenceDto() {}

    public JurisprudenceDto(Long idJurisprudence, Date sentenceDate, String summary, Boolean status, ProvinceDto provinceId,
         SubCategoryDto subcategoryId, FileDto fileId, String txUser, String txHost, Date txDate) {
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

    public Boolean getStatus() {
        return status;
    }

    public ProvinceDto getProvinceId() {
        return provinceId;
    }

    public SubCategoryDto getSubcategoryId() {
        return subcategoryId;
    }

    public FileDto getFileId() {
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

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setProvinceId(ProvinceDto provinceId) {
        this.provinceId = provinceId;
    }

    public void setSubcategoryId(SubCategoryDto subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public void setFileId(FileDto fileId) {
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

    //toString

    @Override
    public String toString() {
        return "JurisprudenceDto{" +
                "idJurisprudence=" + idJurisprudence +
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
