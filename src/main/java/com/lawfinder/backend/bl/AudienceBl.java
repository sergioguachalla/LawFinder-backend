package com.lawfinder.backend.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawfinder.backend.Entity.AudienceEntity;
import com.lawfinder.backend.Entity.InstanceLegalCaseEntity;
import com.lawfinder.backend.dao.AudienceRepository;
import com.lawfinder.backend.dto.AudienceDto;

@Service
public class AudienceBl {
    @Autowired
    private AudienceRepository audienceRepository;

    //Save audience
    public void saveAudience(Long idCase,AudienceDto audienceDto){
        AudienceEntity audienceEntity = new AudienceEntity();
        InstanceLegalCaseEntity instanceLegalCaseEntity = new InstanceLegalCaseEntity();
        instanceLegalCaseEntity.setInstanceLegalCaseId(idCase);
        audienceEntity.setAudienceDate(audienceDto.getAudienceDate());
        audienceEntity.setDescription(audienceDto.getDescription());
        audienceEntity.setLink(audienceDto.getLink());
        audienceEntity.setAddress(audienceDto.getAddress());
        audienceEntity.setInstanceLegalCase(instanceLegalCaseEntity);        
        audienceRepository.saveAndFlush(audienceEntity);
    }
    

    
}
