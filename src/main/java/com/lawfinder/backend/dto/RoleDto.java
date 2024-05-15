package com.lawfinder.backend.dto;

import java.util.List;

public class RoleDto {
    private Long roleId;
    private String roleName;
    private List<String> privileges;
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<String> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<String> privileges) {
        this.privileges = privileges;
    }

    public RoleDto(Long roleId, String roleName, List<String> privileges) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.privileges = privileges;
    }
    public RoleDto(){

    }

    @Override
    public String toString() {
        return "RoleDto{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", privileges=" + privileges +
                '}';
    }
}
