package com.lawfinder.backend.dto;
import java.util.Date;

public class JurisprudenceDto {
    private Long idJurisprudence;
    private String title;
    private String summary;
    private String status;
    private String firstInstanceCourt;
    private String secondInstanceCourt;
    private String thirdInstanceCourt;
    private String txUser;
    private String txHost;
    private Date txDate;

    public JurisprudenceDto() {
    }

    public JurisprudenceDto(String title, String summary, String status, String firstInstanceCourt, String secondInstanceCourt, String thirdInstanceCourt, String txUser, String txHost, Date txDate) {
        this.title = title;
        this.summary = summary;
        this.status = status;
        this.firstInstanceCourt = firstInstanceCourt;
        this.secondInstanceCourt = secondInstanceCourt;
        this.thirdInstanceCourt = thirdInstanceCourt;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    //getters

    public Long getIdJurisprudence() {
        return idJurisprudence;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }


    
}
