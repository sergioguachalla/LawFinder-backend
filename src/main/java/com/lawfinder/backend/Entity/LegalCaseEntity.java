package com.lawfinder.backend.Entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "LEGAL_CASE")
public class LegalCaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LEGAL_CASE_ID")
    private Long legalCaseId;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private UserEntity user;


    @Column(name = "TITLE", length = 2000)
    private String title;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "SUMMARY", columnDefinition = "TEXT")
    private String summary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CRIME_ID", referencedColumnName = "CRIME_ID")
    private CrimeEntity crime;

    @Column(name = "COMPLAINANT" )
    private boolean complainant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROVINCE_ID", nullable = false)
    private ProvinceEntity province;


    @Column(name = "STATUS", length = 100)
    private boolean status;

    @Column(name = "TX_USER", length = 100)
    private String txUser;

    @Column(name = "TX_HOST", length = 100)
    private String txHost;

    @Column(name = "TX_DATE")
    private Date txDate;

    //Para los filtros
    @OneToMany(mappedBy = "legalCase")
    private List<InstanceLegalCaseEntity> instanceLegalCases;

    // para los actores 

    @OneToMany(mappedBy = "legalCaseId")
    private List<ActorEntity> actors;

    // Constructor vacío
    public LegalCaseEntity() {
    }

    // Constructor con todos los atributos
    public LegalCaseEntity( ProvinceEntity province, UserEntity user, CrimeEntity crime ,
    String title, Date startDate, String summary, Boolean status, String txUser, String txHost, Date txDate) {

        this.province = province;
        this.user = user;
        this.title = title;
        this.crime = crime;
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

    public CrimeEntity getCrime() {
        return crime;
    }



    public ProvinceEntity getProvince() {
        return province;
    }

    public UserEntity getUser() {
        return user;
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

    public boolean getStatus() {
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


    public void setProvince(ProvinceEntity province) {
        this.province = province;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }


    public void setCrime(CrimeEntity crime) {
        this.crime = crime;
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

    public void setStatus(Boolean status) {
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

 // para los filtros
    public List<InstanceLegalCaseEntity> getInstanceLegalCases() {
        return instanceLegalCases;
    }

    public void setInstanceLegalCases(List<InstanceLegalCaseEntity> instanceLegalCases) {
        this.instanceLegalCases = instanceLegalCases;
    }
// para los actores

    public List<ActorEntity> getActors() {
        return actors;
    }

    public void setActors(List<ActorEntity> actors) {
        this.actors = actors;
    }
    // toString

    @Override
    public String toString() {
        return "LegalCaseEntity{" +
                "legalCaseId=" + legalCaseId +
                ", user=" + user +
                ", title='" + title + '\'' +
                ", startDate=" + startDate +
                ", summary='" + summary + '\'' +
                ", crime=" + crime +
                ", province=" + province +
                ", status='" + status + '\'' +
                ", txUser='" + txUser + '\'' +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                '}';
    }
}
