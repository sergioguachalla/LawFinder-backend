package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.CourtEntity;
import com.lawfinder.backend.dao.CourtRepository;
import com.lawfinder.backend.dto.CourtDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourtBl {
    @Autowired
    private CourtRepository courtRepository;

    public CourtBl(CourtRepository courtRepository){
        this.courtRepository = courtRepository;
    }

    public List<CourtDto> findAll(){
        
        List<CourtEntity> Court = courtRepository.findAll();
        List<CourtDto> res = new ArrayList<>();
        
        Court.forEach(task -> {
            res.add(new CourtDto(task.getCourtId(), task.getCourtName()));
        });
        return res;

    }



    
}
