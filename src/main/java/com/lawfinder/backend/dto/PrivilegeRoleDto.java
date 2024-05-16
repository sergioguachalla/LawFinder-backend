package com.lawfinder.backend.dto;

import java.util.List;

public class PrivilegeRoleDto {

    private String roleName;
    private List<Long> privileges;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Long> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Long> privileges) {
        this.privileges = privileges;
    }

    public PrivilegeRoleDto(String roleName, List<Long> privileges) {
        this.roleName = roleName;
        this.privileges = privileges;
    }

    public PrivilegeRoleDto() {
    }
}
