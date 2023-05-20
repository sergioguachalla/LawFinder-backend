package com.lawfinder.backend.dto;

public class TokenDto {
    private String authToken;
    private String refreshToken;


    public TokenDto() {}

    // constructor

    public TokenDto(String authToken, String refreshToken) {
        this.authToken = authToken;
        this.refreshToken = refreshToken;
    }






    public String getAuthToken() {
        return this.authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }


    @Override
    public String toString() {
        return "{" +
            " authToken='" + getAuthToken() + "'" +
            ", refreshToken='" + getRefreshToken() + "'" +
            "}";
    }


}