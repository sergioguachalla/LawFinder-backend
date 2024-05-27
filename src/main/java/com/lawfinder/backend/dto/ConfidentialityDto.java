package com.lawfinder.backend.dto;

public class ConfidentialityDto {
   
   private Long confidentialityId;
   private String description;
   private boolean status = true;

   public ConfidentialityDto() {
   }

   public ConfidentialityDto(String description) {
      this.description = description;
   }

   public Long getConfidentialityId() {
      return confidentialityId;
   }
   public void setConfidentialityId(Long confidentialityId) {
      this.confidentialityId = confidentialityId;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public boolean getStatus() {
      return status;
   }

   public void setStatus(boolean status) {
      this.status = status;
   }
}
