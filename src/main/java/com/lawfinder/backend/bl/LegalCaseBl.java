package com.lawfinder.backend.bl;
import com.lawfinder.backend.Entity.*;
import com.lawfinder.backend.dao.*;
import com.lawfinder.backend.dto.*;

import org.apache.tomcat.util.http.fileupload.MultipartStream.ProgressNotifier;
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
        ProvinceEntity province = new ProvinceEntity();
        DepartmentEntity department = new DepartmentEntity();
        CategoryEntity category = new CategoryEntity();
        UserEntity user = new UserEntity();
        PersonEntity person = new PersonEntity();
        province.setProvinceId(Long.valueOf(legalCaseDto.getIdProvince()));
        province.setDepartment(department);
        user.setPersonId(person);
        

        user.setId(Long.valueOf(legalCaseDto.getUserId()));
        legalCaseEntity.setUser(user);

        legalCaseEntity.setTitle(legalCaseDto.getTitle());
        legalCaseEntity.setStartDate(legalCaseDto.getStartDate());
        legalCaseEntity.setSummary(legalCaseDto.getSummary());
        legalCaseEntity.setStatus("En proceso");
        legalCaseEntity.setProvince(province);
        legalCaseEntity.setTxUser("admin");
        legalCaseEntity.setTxHost("192.128.12.3");
        legalCaseEntity.setTxDate(new java.util.Date());
        
        legalCaseRepository.saveAndFlush(legalCaseEntity);
        // Use existing userDto, no need to convert again
        

    }
    
}
