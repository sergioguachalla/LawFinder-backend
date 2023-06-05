package com.lawfinder.backend.dto;

public class DeviceIdDto {
    private String deviceId;
    private String type;
    private String code;

    public DeviceIdDto() {}

    public DeviceIdDto(String deviceId, String type, String code) {
        this.deviceId = deviceId;
        this.type = type;
        this.code = code;
    }

    //getters


    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "DeviceIdDto{" +
                "deviceId='" + deviceId + '\'' +
                ", type='" + type + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
