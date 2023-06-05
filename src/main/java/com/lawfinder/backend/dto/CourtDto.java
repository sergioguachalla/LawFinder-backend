package com.lawfinder.backend.dto;

public class CourtDto {

    private Long idCourt;
    private String courtName;

    public CourtDto() {}

    public CourtDto(Long idCourt ,String courtName) {
        
        this.idCourt = idCourt;
        this.courtName = courtName;
 
    }

    //getters

    public Long getIdCourt() {
        return idCourt;
    }

    public String getCourtName() {
        return courtName;
    }

    //setters

    public void setIdCourt(Long idCourt) {
        this.idCourt = idCourt;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }
    
}
