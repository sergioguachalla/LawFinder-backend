package com.lawfinder.backend.Entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LEGAL_CASE")
public class LegalCaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LEGAL_CASE_ID")
    private Long legalCaseId;

    @OneToOne
    @JoinColumn(name = "SUBCATEGORY_ID", referencedColumnName = "SUBCATEGORY_ID")
    private SubCategoryEntity subcategory;

    @OneToOne
    @JoinColumn(name = "PROVINCE_ID", referencedColumnName = "PROVINCE_ID")
    private ProvinceEntity province;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private UserEntity user;

    @Column(name = "PART", length = 200)
    private String part;

    @Column(name = "CONTRAPART", length = 200)
    private String contrapart;

    @Column(name = "TITLE", length = 2000)
    private String title;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "SUMMARY", columnDefinition = "TEXT")
    private String summary;

    @Column(name = "STATUS", length = 100)
    private String status;

    @Column(name = "TX_USER", length = 100)
    private String txUser;

    @Column(name = "TX_HOST", length = 100)
    private String txHost;

    @Column(name = "TX_DATE")
    private Date txDate;

    // Constructor vacío
    public LegalCaseEntity() {
    }

    // Constructor con todos los atributos
    public LegalCaseEntity(SubCategoryEntity subcategory, ProvinceEntity province, UserEntity user, String part, String contrapart, String title, Date startDate, String summary, String status, String txUser, String txHost, Date txDate) {
        this.subcategory = subcategory;
        this.province = province;
        this.user = user;
        this.part = part;
        this.contrapart = contrapart;
        this.title = title;
        this.startDate = startDate;
        this.summary = summary;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    // Getters
    public Long getLegalCaseId() {
        return legalCaseId;
    }

    public SubCategoryEntity getSubcategory() {
        return subcategory;
    }

    public ProvinceEntity getProvince() {
        return province;
    }

    public UserEntity getUser() {
        return user;
    }

    public String getPart() {
        return part;
    }

    public String getContrapart() {
        return contrapart;
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
    public void setLegalCaseId(Long legalCaseId) {
        this.legalCaseId = legalCaseId;
    }

    public void setSubcategory(SubCategoryEntity subcategory) {
        this.subcategory = subcategory;
    }

    public void setProvince(ProvinceEntity province) {
        this.province = province;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public void setContrapart(String contrapart) {
        this.contrapart = contrapart;
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
        return "LegalCaseEntity [legalCaseId=" + legalCaseId + ", subcategory=" + subcategory + ", province=" + province
                + ", user=" + user + ", part=" + part + ", contrapart=" + contrapart + ", title=" + title
                + ", startDate=" + startDate + ", summary=" + summary + ", status=" + status + ", txUser=" + txUser
                + ", txHost=" + txHost + ", txDate=" + txDate + "]";
    }
}
