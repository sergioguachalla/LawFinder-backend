package com.lawfinder.backend.dto;

public class FileQueryDto {
    private String url;
    private String txDate;
    private String summary;

    public FileQueryDto() {
    }

    public FileQueryDto(String url, String txDate, String summary) {
        this.url = url;
        this.txDate = txDate;
        this.summary = summary;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTxDate() {
        return txDate;
    }

    public void setTxDate(String txDate) {
        this.txDate = txDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
