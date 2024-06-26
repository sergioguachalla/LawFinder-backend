package com.lawfinder.backend.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SE_USER")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USERNAME", length = 100, nullable = false)
    private String username;

    @Column(name = "SECRET", length = 60, nullable = false)
    private String secret;

    @Column(name = "STATUS", nullable = false)
    private Boolean status;

    @Column(name = "ISBLOCKED", nullable = false)
    private Boolean isblocked;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID", nullable = false)
    private PersonEntity personId;
   // @OneToOne (fetch = FetchType.LAZY)
    //@JoinColumn(name = "IMAGE_ID", nullable = false)
   /* @Column(name = "IMAGE_ID", nullable = false)
    private int imageId;*/

    @Column(name = "TX_USER", length = 100, nullable = false)
    private String txUser;

    @Column(name = "TX_HOST", length = 100, nullable = false)
    private String txHost;

    @Column(name = "TX_DATE", nullable = false)
    private Date txDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<LegalCaseEntity> legalCases;

    // Constructor vacío
    public UserEntity() {}

    // Getters y setters


    public UserEntity(Long id, String username, String secret, 
    Boolean status, Boolean isblocked, PersonEntity personId, //int imageId,
                       String txUser,
    String txHost, Date txDate) {
        this.id = id;
        this.username = username;
        this.secret = secret;
        this.status = status;
        this.isblocked = isblocked;
        this.personId = personId;
        //this.imageId = imageId;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public PersonEntity getPersonId() {
        return personId;
    }

    public void setPersonId(PersonEntity personId) {
        this.personId = personId;
    }

    /*public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
*/
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

    public Boolean getIsblocked() {
        return isblocked;
    }

    public void setIsblocked(Boolean isblocked) {
        this.isblocked = isblocked;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", secret='" + secret + '\'' +
                ", status=" + status +
                ", personId=" + personId +

                ", txUser='" + txUser + '\'' +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                '}';
    }
}
