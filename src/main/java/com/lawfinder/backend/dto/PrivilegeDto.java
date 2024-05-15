package com.lawfinder.backend.dto;

public class PrivilegeDto {
    private Long privilegeId;
    private String privilege;

    // Getters and Setters
    public Long getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Long privilegeId) {
        this.privilegeId = privilegeId;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public PrivilegeDto(Long privilegeId, String privilege) {
        this.privilegeId = privilegeId;
        this.privilege = privilege;
    }
}
