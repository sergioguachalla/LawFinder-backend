
package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.ProvinceEntity;
import com.lawfinder.backend.dao.ProvinceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceBl {
    private final ProvinceRepository provinceRepository;
    public ProvinceBl(ProvinceRepository provinceRepository){
        this.provinceRepository = provinceRepository;
    }

    public ProvinceEntity saveProvince(ProvinceEntity provinceEntity){
        return provinceRepository.save(provinceEntity);
    }

    public List<ProvinceEntity> findAll(){
        return provinceRepository.findAll();
    }

}
