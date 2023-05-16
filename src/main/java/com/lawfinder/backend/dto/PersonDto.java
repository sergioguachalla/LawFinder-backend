package com.lawfinder.backend.dto;

import com.lawfinder.backend.Entity.AddressEntity;

public class PersonDto {
    private Long personId;
    private String name;
    private String lastname;
    private String number;
    private String email;
    private AddressEntity address;

    public PersonDto() {}

    public PersonDto(Long personId, String name, String lastname, String number, String email, AddressEntity address) {
        this.personId = personId;
        this.name = name;
        this.lastname = lastname;
        this.number = number;
        this.email = email;
        this.address = address;
    }

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

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", number='" + number + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}
