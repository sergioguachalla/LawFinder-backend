package com.lawfinder.backend.dto;

public class InstanceDto {
    private Long instanceId;
    private String instanceName;

    public InstanceDto() {
    }

    public InstanceDto(Long instanceId, String instanceName) {
        this.instanceId = instanceId;
        this.instanceName = instanceName;
    }

    public Long getInstanceId() {
        return instanceId;
    }

    public String getInstanceName() {
        return instanceName;
    }



    public void setInstanceId(Long instanceId) {
        this.instanceId = instanceId;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }


}
