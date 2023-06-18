package com.lawfinder.backend.bl;

import java.util.ArrayList;
import java.util.List;

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

    // obtener audiencias
    /*
    public List<AudienceDto> findByuserId(Long id){
        List<AudienceEntity> audienceEntity = audienceRepository.findaudienceByuserId(id);
        return convertToDto(audienceEntity);
    }*/



    // convertir audienceEntity a audienceDto
    public List<AudienceDto> convertToDto(List<AudienceEntity> audienceEntity){
        List<AudienceDto> audienceDto = new ArrayList<>();
        audienceEntity.forEach(audienceEntity1 -> {
            AudienceDto audienceDto1 = new AudienceDto();
            audienceDto1.setAudienceId(audienceEntity1.getAudienceId());
            audienceDto1.setAudienceDate(audienceEntity1.getAudienceDate());
            audienceDto1.setDescription(audienceEntity1.getDescription());
            audienceDto1.setLink(audienceEntity1.getLink());
            audienceDto1.setAddress(audienceEntity1.getAddress());
            audienceDto1.setInstanceLegalCaseId(audienceEntity1.getInstanceLegalCase().getInstanceLegalCaseId());
            audienceDto.add(audienceDto1);
        });
        return audienceDto;
    }

    
}
