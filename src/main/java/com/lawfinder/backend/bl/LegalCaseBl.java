package com.lawfinder.backend.bl;
import com.lawfinder.backend.Entity.*;
import com.lawfinder.backend.dao.*;
import com.lawfinder.backend.dto.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class LegalCaseBl {

    private final LegalCaseRepository legalCaseRepository;
    private final UserRepository userRepository;

    public LegalCaseBl(LegalCaseRepository legalCaseRepository, UserRepository userRepository) {
        this.legalCaseRepository = legalCaseRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveLegalCase(LegalCaseDto legalCaseDto) {
        LegalCaseEntity legalCaseEntity = new LegalCaseEntity();

        // Convert UserDto to UserEntity
        UserDto userDto = legalCaseDto.getUser();
        UserEntity userEntity = userRepository.findById(userDto.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Set properties from legalCaseDto to legalCaseEntity
        legalCaseEntity.setTitle(legalCaseDto.getTitle());
        legalCaseEntity.setStartDate(legalCaseDto.getStartDate());
        legalCaseEntity.setSummary(legalCaseDto.getSummary());
        legalCaseEntity.setStatus(legalCaseDto.getStatus());
        legalCaseEntity.setFirstInstanceCourt(legalCaseDto.getFirstInstanceCourt());
        legalCaseEntity.setSecondInstanceCourt(legalCaseDto.getSecondInstanceCourt());
        legalCaseEntity.setThirdInstanceCourt(legalCaseDto.getThirdInstanceCourt());
        legalCaseEntity.setTxUser(legalCaseDto.getTxUser());
        legalCaseEntity.setTxHost(legalCaseDto.getTxHost());
        legalCaseEntity.setTxDate(legalCaseDto.getTxDate());
        legalCaseEntity.setUser(userEntity);

        // Save legalCaseEntity in the database
        legalCaseEntity = legalCaseRepository.save(legalCaseEntity);

        // Convert legalCaseEntity back to legalCaseDto and return it
        LegalCaseDto savedLegalCaseDto = new LegalCaseDto();
        savedLegalCaseDto.setIdLegalCase(legalCaseEntity.getIdLegalCase());
        savedLegalCaseDto.setTitle(legalCaseEntity.getTitle());
        savedLegalCaseDto.setStartDate(legalCaseEntity.getStartDate());
        savedLegalCaseDto.setSummary(legalCaseEntity.getSummary());
        savedLegalCaseDto.setStatus(legalCaseEntity.getStatus());
        savedLegalCaseDto.setFirstInstanceCourt(legalCaseEntity.getFirstInstanceCourt());
        savedLegalCaseDto.setSecondInstanceCourt(legalCaseEntity.getSecondInstanceCourt());
        savedLegalCaseDto.setThirdInstanceCourt(legalCaseEntity.getThirdInstanceCourt());
        savedLegalCaseDto.setTxUser(legalCaseEntity.getTxUser());
        savedLegalCaseDto.setTxHost(legalCaseEntity.getTxHost());
        savedLegalCaseDto.setTxDate(legalCaseEntity.getTxDate());

        // Use existing userDto, no need to convert again
        savedLegalCaseDto.setUser(userDto);

    }
    
}
