package com.lawfinder.backend.bl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawfinder.backend.Entity.LegalCaseEntity;
import com.lawfinder.backend.dao.ConfidentialityRepository;
import com.lawfinder.backend.dao.InstanceLegalCaseRepository;
import com.lawfinder.backend.dao.InstanceRepository;
import com.lawfinder.backend.dao.LegalCaseRepository;
import com.lawfinder.backend.dto.InformationAssetDto;

@Service
public class InformationAssetsClassificationBl {
   
   @Autowired
   private final LegalCaseRepository legalCaseRepository;
   private final ConfidentialityRepository confidentialityRepository;
   private final InstanceLegalCaseRepository instanceLegalCaseRepository;
   private final InstanceRepository instanceRepository;

   public InformationAssetsClassificationBl(LegalCaseRepository legalCaseRepository,
         ConfidentialityRepository confidentialityRepository, InstanceLegalCaseRepository instanceLegalCaseRepository,
         InstanceRepository instanceRepository) {
      this.legalCaseRepository = legalCaseRepository;
      this.confidentialityRepository = confidentialityRepository;
      this.instanceLegalCaseRepository = instanceLegalCaseRepository;
      this.instanceRepository = instanceRepository;
   }

   public List<InformationAssetDto> findAllInformationAssets(){
      List<LegalCaseEntity> legalCases = legalCaseRepository.findAll();
      List<InformationAssetDto> informationAssets = new ArrayList<InformationAssetDto>();
      for(LegalCaseEntity legalCase : legalCases){
         InformationAssetDto informationAsset = new InformationAssetDto();

         legalCase.getInstanceLegalCases().forEach(instanceLegalCase -> {
            informationAsset.setInformationAssetId(legalCase.getLegalCaseId());
            informationAsset.setInstance(instanceLegalCase.getInstance().getInstanceName());
            informationAsset.setCategory(legalCase.getCrime().getName());

            informationAsset.setConfidentiality(legalCase.getConfidentiality().getDescription());
         });
         informationAssets.add(informationAsset);

      }

      return informationAssets;
   }


   

}
