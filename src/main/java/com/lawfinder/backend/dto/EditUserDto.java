package com.lawfinder.backend.dto;

import java.util.List;

public class EditUserDto {
    private Long id;
    private String username;
    private String email;
    private String password;
    private List<UserRoleDto> roles;

    private List<UserRoleDto> allRoles;

    public EditUserDto() {
    }



    public EditUserDto(Long id, String username, String email, String password, List<UserRoleDto> roles, List<UserRoleDto> allRoles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.allRoles = allRoles;
    }
    public List<UserRoleDto> getAllRoles() {
        return allRoles;
    }

    public void setAllRoles(List<UserRoleDto> allRoles) {
        this.allRoles = allRoles;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserRoleDto> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRoleDto> roles) {
        this.roles = roles;
    }
}
