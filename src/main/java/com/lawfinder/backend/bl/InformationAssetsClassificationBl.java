package com.lawfinder.backend.bl;

import java.util.ArrayList;
import java.util.List;

import com.lawfinder.backend.dto.ConfidentialCaseDto;
import com.lawfinder.backend.dto.ConfidentialityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
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



   public Page<ConfidentialCaseDto> findAllConfidentialCases(Pageable pageable, Long confidentiality){
      Specification<LegalCaseEntity> specification = Specification.where(null);
        if(confidentiality != null){
             specification = specification.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("confidentiality"), confidentiality));
        }
        return legalCaseRepository.findAll(specification, pageable).map((this::mapToLegalDto));
   }

    private ConfidentialCaseDto mapToLegalDto(LegalCaseEntity legalCaseEntity){
        ConfidentialCaseDto confidentialCaseDto = new ConfidentialCaseDto();
        confidentialCaseDto.setCaseId(legalCaseEntity.getLegalCaseId());
        confidentialCaseDto.setConfidentiality(legalCaseEntity.getConfidentiality().getDescription());
        confidentialCaseDto.setCaseName(legalCaseEntity.getTitle());
        confidentialCaseDto.setCaseDescription(legalCaseEntity.getSummary());
        confidentialCaseDto.setCrime(legalCaseEntity.getCrime().getName());
        confidentialCaseDto.setStartDate(legalCaseEntity.getStartDate());

        return confidentialCaseDto;
    }



    public List<ConfidentialityDto> getAllConfidentialities(){
        List<ConfidentialityDto> confidentialities = new ArrayList<>();
        confidentialityRepository.findAll().forEach(confidentiality -> {
            ConfidentialityDto confidentialityDto = new ConfidentialityDto();
            confidentialityDto.setConfidentialityId(confidentiality.getConfidentialityId());
            confidentialityDto.setDescription(confidentiality.getDescription());
            confidentialities.add(confidentialityDto);
        });
        return confidentialities;
    }






   

}
