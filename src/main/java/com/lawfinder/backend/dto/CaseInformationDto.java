package com.lawfinder.backend.dto;

public class CaseInformationDto {

    String provinceName;
    String title;
    String summary;
    String username;
    String instanceName;
    String txDate;

    String subCategoryName;

    String crimeName;

    public CaseInformationDto() {
    }

    public CaseInformationDto(String provinceName, String title, String summary, String username, String instanceName, String txDate, String subCategoryName, String crimeName) {
        this.provinceName = provinceName;
        this.title = title;
        this.summary = summary;
        this.username = username;
        this.instanceName = instanceName;
        this.txDate = txDate;
        this.subCategoryName = subCategoryName;
        this.crimeName = crimeName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public String getTxDate() {
        return txDate;
    }

    public void setTxDate(String txDate) {
        this.txDate = txDate;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public String getCrimeName() {
        return crimeName;
    }

    public void setCrimeName(String crimeName) {
        this.crimeName = crimeName;
    }
}

