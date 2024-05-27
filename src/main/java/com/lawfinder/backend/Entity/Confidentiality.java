package com.lawfinder.backend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CONFIDENTIALITY")
public class Confidentiality {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ID_CONFIDENTIALITY")
   private Long confidentialityId;
   

   @Column(name = "DESCRIPTION", length = 100)
   private String description;

   @Column(name = "STATUS")
   private boolean status = true;

   //constructor
   public Confidentiality() {
   }

   public Confidentiality(String description) {
      this.description = description;
   }

   //getters and setters
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
