package com.lawfinder.backend.dto;
import java.util.Date;

public class FileDto {
    private Long fileId;
    private String url;
    private String mimeType;
    private String size;
    private String md5;
    private String txUser;
    private String txHost;
    private Date txDate;

    public FileDto() {}

    public FileDto(Long fileId, String url, String mimeType, String size, String md5, String txUser, String txHost, Date txDate){
        
        this.fileId = fileId;
        this.url = url;
        this.mimeType = mimeType;
        this.size = size;
        this.md5 = md5;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    //getters

    public Long getFileId() {
        return fileId;
    }

    public String getUrl() {
        return url;
    }

    public String getMimeType() {
        return mimeType;
    }

    public String getSize() {
        return size;
    }

    public String getMd5() {
        return md5;
    }

    public String getTxUser() {
        return txUser;
    }

    public String getTxHost() {
        return txHost;
    }

    public Date getTxDate() {
        return txDate;
    }

    //setters
    
    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public void setTxUser(String txUser) {
        this.txUser = txUser;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }

    //toString

    @Override
    public String toString() {
        return "FileDto [fileId=" + fileId + ", md5=" + md5 + ", mimeType=" + mimeType + ", size=" + size + ", txDate="
                + txDate + ", txHost=" + txHost + ", txUser=" + txUser + ", url=" + url + "]";
    }

}
