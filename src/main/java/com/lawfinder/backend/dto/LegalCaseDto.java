package com.lawfinder.backend.dto;

import java.util.Date;

public class LegalCaseDto {

    private Long idLegalCase;
    private int idProvince;
    private int idCrime;
    private int userId;
    private String part;
    private String contrapart;
    private String title;
    private Date startDate;
    private String summary;

    private boolean complaint;
    //Para guardar la instancia
    private int idInstance;
    private String counterpartName;



    private Date startDateInstance;
    private Date endDateInstance;

    private Date lastUpdate;


    public LegalCaseDto() {
    }

    public LegalCaseDto(Long idLegalCase, int idSubCategory, int idProvince, int idCrime ,int userId, String part, String contrapart,
                        String title, Date startDate, String summary, int idInstance, Date startDateInstance, Date endDateInstance,
                        Date lastUpdate, boolean complaint, String counterpartName) {
        this.idLegalCase = idLegalCase;
        this.idProvince = idProvince;
        this.idCrime = idCrime;
        this.userId = userId;
        this.part = part;
        this.contrapart = contrapart;
        this.title = title;
        this.startDate = startDate;
        this.summary = summary;
        this.idInstance = idInstance;
        this.startDateInstance = startDateInstance;
        this.endDateInstance = endDateInstance;
        this.lastUpdate = lastUpdate;
        this.complaint = complaint;
        this.counterpartName = counterpartName;
        
        

    }

    public Long getIdLegalCase() {
        return idLegalCase;
    }

    public void setIdLegalCase(Long idLegalCase) {
        this.idLegalCase = idLegalCase;
    }



    public int getIdProvince() {
        return idProvince;
    }

    public void setIdProvince(int idProvince) {
        this.idProvince = idProvince;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public int getIdCrime() {
        return idCrime;
    }

    public void setIdCrime(int idCrime) {
        this.idCrime = idCrime;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getIdInstance() {
        return idInstance;
    }

    public void setIdInstance(int idInstance) {
        this.idInstance = idInstance;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getContrapart() {
        return contrapart;
    }

    public void setContrapart(String contrapart) {
        this.contrapart = contrapart;
    }

    public Date getStartDateInstance() {
        return startDateInstance;
    }

    public void setStartDateInstance(Date startDateInstance) {
        this.startDateInstance = startDateInstance;
    }

    public Date getEndDateInstance() {
        return endDateInstance;
    }

    public boolean isComplaint() {
        return complaint;
    }

    public void setComplaint(boolean complaint) {
        this.complaint = complaint;
    }

    public void setEndDateInstance(Date endDateInstance) {
        this.endDateInstance = endDateInstance;
    }

    public String getCounterpartName() {
        return counterpartName;
    }

    public void setCounterpartName(String counterpartName) {
        this.counterpartName = counterpartName;
    }


}
