package com.lawfinder.backend.dto;

public class CounterpartDto {
    private Long counterpartId;
    private String counterpartName;
    private int legalCaseId;

    // Constructor
    public CounterpartDto() {}

    // Constructor con todos los atributos
    public CounterpartDto(Long counterpartId, String counterpartName, int legalCaseId) {
        this.counterpartId = counterpartId;
        this.counterpartName = counterpartName;
        this.legalCaseId = legalCaseId;
    }

    // Getters y Setters
    public Long getCounterpartId() {
        return counterpartId;
    }

    public void setCounterpartId(Long counterpartId) {
        this.counterpartId = counterpartId;
    }

    public String getCounterpartName() {
        return counterpartName;
    }

    public void setCounterpartName(String counterpartName) {
        this.counterpartName = counterpartName;
    }

    public int getLegalCaseId() {
        return legalCaseId;
    }

    public void setLegalCaseId(int legalCaseId) {
        this.legalCaseId = legalCaseId;
    }
}
