package com.lawfinder.backend.Entity;
import jakarta.persistence.*;

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

    /* 
    @Column(name = "ADRESS_ID")
    private int address;
    */
    
    @OneToOne
    @JoinColumn(name = "ADRESS_ID", referencedColumnName = "ADDRESS_ID")
    private AddressEntity address;
    
    // Constructor
    public PersonEntity() {}
    // Constructor con todos los atributos

    public PersonEntity(String name, String lastname, String number, String email, AddressEntity address){
        this.name = name;
        this.lastname = lastname;
        this.number = number;
        this.email = email;
        this.address = address;
    }

    // Getters

    public Long getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNumber() {
        return number;
    }

    public String getEmail() {
        return email;
    }

    public AddressEntity getAddress() {
        return address;
    }

    // Setters

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    // toString

    @Override
    public String toString() {
        return "PersonEntity [address=" + address + ", email=" + email + ", lastname=" + lastname + ", name=" + name
                + ", number=" + number + ", personId=" + personId + "]";
    }

    
}
