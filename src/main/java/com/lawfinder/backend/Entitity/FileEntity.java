package com.lawfinder.backend.Entitity;
import jakarta.persistence.*;
import java.util.Date;


@Entity
@Table(name = "FILE")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FILE_ID")
    private Long fileId;

    @Column(name = "URL")
    private String url;

    @Column(name = "MIME_TYPE")
    private String mimeType;

    @Column(name = "SIZE")
    private String size;

    @Column(name = "MD5")
    private String md5;

    @Column(name = "TX_USER")
    private String txUser;

    @Column(name = "TX_HOST")
    private String txHost;

    @Column(name = "TX_DATE")
    private Date txDate;

    //Constructor vaciO
    public FileEntity() {}

    //Constructor con todos los atributos
    public FileEntity(String url, String mimeType, String size, String md5, String txUser, String txHost, Date txDate){
        this.url = url;
        this.mimeType = mimeType;
        this.size = size;
        this.md5 = md5;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    //Getters

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

    //Setters

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
        return "FileEntity [fileId=" + fileId + ", md5=" + md5 + ", mimeType=" + mimeType + ", size=" + size
                + ", txDate=" + txDate + ", txHost=" + txHost + ", txUser=" + txUser + ", url=" + url + "]";
    }

}
