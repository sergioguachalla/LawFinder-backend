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
    private final InstanceLegalCaseRepository instanceLegalCaseRepository;

    public LegalCaseBl(LegalCaseRepository legalCaseRepository, InstanceLegalCaseRepository instanceLegalCaseRepository) {
        this.legalCaseRepository = legalCaseRepository;
        this.instanceLegalCaseRepository = instanceLegalCaseRepository;    
    }

    @Transactional
    public void saveLegalCase(LegalCaseDto legalCaseDto) {
        LegalCaseEntity legalCaseEntity = new LegalCaseEntity();
        ProvinceEntity province = new ProvinceEntity();
        DepartmentEntity department = new DepartmentEntity();
        UserEntity user = new UserEntity();
        PersonEntity person = new PersonEntity();
        CrimeEntity crime = new CrimeEntity();



        province.setProvinceId(Long.valueOf(legalCaseDto.getIdProvince()));
        province.setDepartment(department);
        user.setPersonId(person);
        crime.setCrimeId(legalCaseDto.getIdCrime());
        

        user.setId(Long.valueOf(legalCaseDto.getUserId()));
        legalCaseEntity.setUser(user);

        legalCaseEntity.setTitle(legalCaseDto.getTitle());
        legalCaseEntity.setStartDate(legalCaseDto.getStartDate());
        legalCaseEntity.setSummary(legalCaseDto.getSummary());
        legalCaseEntity.setCrime(crime);
        legalCaseEntity.setStatus(true);
        legalCaseEntity.setProvince(province);
        legalCaseEntity.setTxUser("admin");
        legalCaseEntity.setTxHost("192.128.12.3");
        legalCaseEntity.setTxDate(new java.util.Date());
        
        legalCaseRepository.saveAndFlush(legalCaseEntity);
        // Register the initial instance on db
        
        
        InstanceLegalCaseEntity instanceCase= new InstanceLegalCaseEntity();
        InstanceEntity instance = new InstanceEntity();
        instance.setInstanceId((long) legalCaseDto.getIdInstance());
        instanceCase.setInstance(instance);
        instanceCase.setLegalCase(legalCaseEntity);
        instanceCase.setStartDate(legalCaseDto.getStartDateInstance());
        instanceCase.setEndDate(legalCaseDto.getEndDateInstance());
        instanceLegalCaseRepository.saveAndFlush(instanceCase);
        
        
    }
    
}
