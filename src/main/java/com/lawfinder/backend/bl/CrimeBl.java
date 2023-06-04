package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.CrimeEntity;
import com.lawfinder.backend.dao.CrimeRepository;
import com.lawfinder.backend.dto.CrimeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CrimeBl {
    @Autowired
    private CrimeRepository crimeRepository;


    public List<CrimeDto> getCrimesBySubcategoryId(Long subcategoryId){
        List<CrimeEntity> crimeEntities = crimeRepository.findAllBySubcategoryId(subcategoryId);
        List<CrimeDto> crimeDtos = new ArrayList<>();
        for (CrimeEntity crimeEntity : crimeEntities) {
            CrimeDto crimeDto = new CrimeDto();
            crimeDto.setCrimeId(crimeEntity.getCrimeId());
            crimeDto.setName(crimeEntity.getName());
            crimeDto.setPrisonSentence(Integer.parseInt(crimeEntity.getPrisonSentence()));
            crimeDto.setSubcategoryId(crimeEntity.getSubcategoryId().getSubCategoryId());
            crimeDtos.add(crimeDto);
        }
        return crimeDtos;

    }
}
