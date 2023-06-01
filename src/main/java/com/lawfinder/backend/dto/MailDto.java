package com.lawfinder.backend.dto;

public class MailDto {
    private String mail;

    public MailDto() {}

    public MailDto(String mail) {
        this.mail = mail;
    }

    //getters

    public String getMail() {
        return mail;
    }

    //setters

    public void setMail(String mail) {
        this.mail = mail;
    }

    // toString

    @Override
    public String toString() {
        return "MailDto{" +
                "mail='" + mail + '\'' +
                '}';
    }
    
}
