package com.lawfinder.backend.Entity;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "PERSON")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSON_ID")
    private Long personId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "NUMBER", length = 100)
    private String number;

    @Column(name = "EMAIL", length = 300)
    private String email;


    @Column(name = "CI")
    private String ci;

    @Column(name = "COMPLEMENT",nullable = true)
    private String complement;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "TX_USER")
    private String tx_user;

    @Column(name = "TX_DATE")
    private Date tx_date;

    @Column(name = "TX_HOST")
    private String tx_host;
    
    // Constructor
    public PersonEntity() {}
    // Constructor con todos los atributos

    public PersonEntity(String name, String lastname, String number, String ci, String email, String address,
    String tx_user, Date tx_date, String tx_host, String complement){
        this.name = name;
        this.lastname = lastname;
        this.number = number;
        this.email = email;
        this.address = address;
        this.ci = ci;
        this.tx_user = tx_user;
        this.tx_date = tx_date;
        this.tx_host = tx_host;
        this.complement = complement;


    }

    // Getters

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTx_user() {
        return tx_user;
    }

    public void setTx_user(String tx_user) {
        this.tx_user = tx_user;
    }

    public Date getTx_date() {
        return tx_date;
    }

    public void setTx_date(Date tx_date) {
        this.tx_date = tx_date;
    }

    public String getTx_host() {
        return tx_host;
    }

    public void setTx_host(String tx_host) {
        this.tx_host = tx_host;
    }

    // toString
    @Override
    public String toString() {
        return "PersonEntity [address=" + address + ", email=" + email + ", lastname=" + lastname + ", name=" + name
                + ", number=" + number + ", personId=" + personId + "]";
    }



    
}
