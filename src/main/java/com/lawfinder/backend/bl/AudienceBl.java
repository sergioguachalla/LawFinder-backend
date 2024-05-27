package com.lawfinder.backend.bl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lawfinder.backend.Entity.ApplicationLogEntity;
import com.lawfinder.backend.Entity.LegalCaseEntity;
import com.lawfinder.backend.Entity.LogCategoryEntity;
import com.lawfinder.backend.dao.ApplicationLogRepository;
import com.lawfinder.backend.dao.LogCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawfinder.backend.Entity.AudienceEntity;
import com.lawfinder.backend.dao.AudienceRepository;
import com.lawfinder.backend.dto.AudienceDto;

@Service
public class AudienceBl {
    @Autowired private AudienceRepository audienceRepository;
    @Autowired private ApplicationLogRepository applicationLogRepository;
    @Autowired private LogCategoryRepository logCategoryRepository;
    @Autowired private LogBl logBl;

    //Save audience
    public void saveAudience(Long idCase,AudienceDto audienceDto, String username, String ipAddress){
        AudienceEntity audienceEntity = new AudienceEntity();
        LogCategoryEntity logCategoryEntity = new LogCategoryEntity();
        logCategoryEntity = logCategoryRepository.findById(1L).get();

        LegalCaseEntity legalCaseEntity = new LegalCaseEntity();
        legalCaseEntity.setLegalCaseId(idCase);
        audienceEntity.setAudienceDate(audienceDto.getAudienceDate());
        audienceEntity.setDescription(audienceDto.getDescription());
        audienceEntity.setLink(audienceDto.getLink());
        audienceEntity.setAddress(audienceDto.getAddress());
        audienceEntity.setLegalCaseId(legalCaseEntity);
        audienceRepository.saveAndFlush(audienceEntity);

        //Logs
        logBl.saveLog(username,
                        "Se ha creado una audiencia con fecha: " + audienceDto.getAudienceDate() +
                " en el caso con id: " + idCase + ", con id de audiencia: " + audienceEntity.getAudienceId(),
                        1L, ipAddress, 1L);
    }

    // obtener audiencias

    public List<AudienceDto> findByuserId(Long id){
        List<AudienceEntity> audienceEntity = audienceRepository.findAudienceByUserId(id);
        return convertToDto(audienceEntity);
    }



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
            audienceDto1.setInstanceLegalCaseId(audienceEntity1.getLegalCaseId().getLegalCaseId());
            audienceDto.add(audienceDto1);
        });
        return audienceDto;
    }

    
}
