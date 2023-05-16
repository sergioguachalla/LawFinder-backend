package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.JurisprudenceEntity;
import com.lawfinder.backend.dao.JurisprudenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JurisprudenceBl {
    private final JurisprudenceRepository jurisprudenceRepository;
    public JurisprudenceBl(JurisprudenceRepository jurisprudenceRepository){
        this.jurisprudenceRepository = jurisprudenceRepository;
    }

    public JurisprudenceEntity saveJurisprudence(JurisprudenceEntity jurisprudenceEntity){
        return jurisprudenceRepository.save(jurisprudenceEntity);
    }

    public List<JurisprudenceEntity> findAll(){
        return jurisprudenceRepository.findAll();
    }

}
