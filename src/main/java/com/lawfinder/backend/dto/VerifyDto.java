package com.lawfinder.backend.dto;

public class VerifyDto {
    private String email;
    private String token;

    public VerifyDto() {}

    public VerifyDto(String email, String token) {
        this.email = email;
        this.token = token;
    }

    //getters

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }

    //setters

    public void setEmail(String email) {
        this.email = email;
    }

    public void setToken(String token) {
        this.token = token;
    }

    // toString

    @Override
    public String toString() {
        return "VerifyDto{" +
                "email='" + email + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    
}
