package com.lawfinder.backend.dto;

public class ResetPasswordDto {
    private String password;

    public ResetPasswordDto() {
    }

    public ResetPasswordDto(String password){
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

}
