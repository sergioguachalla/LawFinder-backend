package com.lawfinder.backend.dto;

public class RoleUpdateDto {
    private Long privilegeId;
    private String privilege;
    private boolean status;

    public RoleUpdateDto(Long privilegeId, String privilege, boolean status) {
        this.privilegeId = privilegeId;
        this.privilege = privilege;
        this.status = status;
    }

    public RoleUpdateDto() {}

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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
