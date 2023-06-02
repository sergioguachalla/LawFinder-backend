package com.lawfinder.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SE_VERIFICATION")
public class VerificationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VERIFICATION_ID")
    private Long verificationId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")

    private PersonEntity personId;

    @Column(name = "TOKEN")
    private String token;

    // Constructor, getters, setters y otros métodos si es necesario

    // Constructor vacío
    public VerificationEntity() {

    }


    // Constructor con todos los atributos
    public VerificationEntity(PersonEntity personId, String token) {
        this.personId = personId;
        this.token = token;
    }

    // Getters y Setters

    public Long getVerificationId() {
        return verificationId;
    }

    public void setVerificationId(Long verificationId) {
        this.verificationId = verificationId;
    }

    public PersonEntity getPersonId() {
        return personId;
    }

    public void setPersonId(PersonEntity personId) {
        this.personId = personId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
