package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.LegalFileTypeEntity;
import com.lawfinder.backend.dao.LegalFileTypeRepository;
import com.lawfinder.backend.dto.LegalFileTypeDto;

import com.lawfinder.backend.dto.ProvinceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class LegalFileTypeBl {
    @Autowired
    private LegalFileTypeRepository legalFileTypeRepository;

    public LegalFileTypeBl(LegalFileTypeRepository legalFileTypeRepository){
        this.legalFileTypeRepository = legalFileTypeRepository;
    }

    //find all

    public List<LegalFileTypeDto> findAll(){
        
        List<LegalFileTypeEntity> LegalFileType = legalFileTypeRepository.findAll();
        List<LegalFileTypeDto> res = new ArrayList<>();
        
        LegalFileType.forEach(file -> {
            res.add(new LegalFileTypeDto(file.getLegalFileTypeId(), file.getName()));
        });
        return res;

    }
    
    
}
