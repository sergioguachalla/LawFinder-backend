package com.lawfinder.backend.Entitity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "H_FILE")
public class HistoryFileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "H_FILE_ID")
    private Long id;

    @Column(name = "URL", nullable = false)
    private String url;

    @Column(name = "MIME_TYPE", nullable = false)
    private String mimeType;

    @Column(name = "SIZE", nullable = false)
    private String size;

    @Column(name = "MD5", nullable = false)
    private String md5;

    @Column(name = "TX_USER", nullable = false)
    private String txUser;

    @Column(name = "TX_HOST", nullable = false)
    private String txHost;

    @Column(name = "TX_DATE", nullable = false)
    private Date txDate;

    // constructors

    public HistoryFileEntity() {
    }

    public HistoryFileEntity(String url, String mimeType, String size, String md5, String txUser, String txHost, Date txDate) {
        this.url = url;
        this.mimeType = mimeType;
        this.size = size;
        this.md5 = md5;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getTxUser() {
        return txUser;
    }

    public void setTxUser(String txUser) {
        this.txUser = txUser;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }

    @Override
    public String toString() {
        return "HistoryFileEntity{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", size='" + size + '\'' +
                ", md5='" + md5 + '\'' +
                ", txUser='" + txUser + '\'' +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                '}';
    }
}
