package com.lawfinder.backend.dto;

public class InformationAssetDto {
   private Long informationAssetId;
   private String description;
   private String instance;
   private String category;
   private String confidentiality;

   public InformationAssetDto() {
   }

   public InformationAssetDto(Long informationAssetId, String description, String instance, String category,
         String confidentiality) {
      this.informationAssetId = informationAssetId;
      this.description = description;
      this.instance = instance;
      this.category = category;
      this.confidentiality = confidentiality;
   }

   public Long getInformationAssetId() {
      return informationAssetId;
   }

   public void setInformationAssetId(Long informationAssetId) {
      this.informationAssetId = informationAssetId;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getInstance() {
      return instance;
   }

   public void setInstance(String instance) {
      this.instance = instance;
   }

   public String getCategory() {
      return category;
   }

   public void setCategory(String category) {
      this.category = category;
   }

   public String getConfidentiality() {
      return confidentiality;
   }

   public void setConfidentiality(String confidentiality) {
      this.confidentiality = confidentiality;
   }

   
}
