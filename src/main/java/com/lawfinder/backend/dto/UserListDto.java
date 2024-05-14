package com.lawfinder.backend.dto;

import java.util.List;

public class UserListDto {
    private Long id;
    private String username;
    private List<String> roles;
    private boolean isblocked;

    public UserListDto() {
    }

    public UserListDto(Long id, String username, List<String> roles, boolean isblocked) {
        this.id = id;
        this.username = username;
        this.roles = roles;
        this.isblocked = isblocked;
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



    public boolean isIsblocked() {
        return isblocked;
    }

    public void setIsblocked(boolean isblocked) {
        this.isblocked = isblocked;
    }


    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserListDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", roles=" + roles +
                ", isblocked=" + isblocked +
                '}';
    }
}
