package com.lawfinder.backend.dto;


public class PersonDto {
    private Long personId;
    private String name;
    private String lastname;
    private String number;
    private String email;
    private String address;
    private String ci;

    public PersonDto() {}

    public PersonDto(Long personId, String name, String lastname, String number, String ci, String email, String address) {
        this.personId = personId;
        this.name = name;
        this.lastname = lastname;
        this.ci = ci;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getCi() {
        return ci;
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
