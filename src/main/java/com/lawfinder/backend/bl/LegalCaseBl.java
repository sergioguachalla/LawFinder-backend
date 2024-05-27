package com.lawfinder.backend.bl;
import com.lawfinder.backend.Entity.*;
import com.lawfinder.backend.dao.*;
import com.lawfinder.backend.dto.*;
import com.lawfinder.backend.specifications.LegalCaseSpecifications;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import java.util.Date;

import java.util.List;
import java.util.Stack;


@Service
public class LegalCaseBl {
    @Autowired LogBl logBl;
    @Autowired
    private final LegalCaseRepository legalCaseRepository;
    private final InstanceLegalCaseRepository instanceLegalCaseRepository;
    private final InstanceRepository instanceRepository;
    private final UserRepository userRepository;
    private final ActorRepository actorRepository;
    private final CounterpartRepository counterpartRepository;
    private final ConfidentialityRepository confidentialityRepository;


    public LegalCaseBl(LegalCaseRepository legalCaseRepository, InstanceLegalCaseRepository instanceLegalCaseRepository, 
                        InstanceRepository instanceRepository, UserRepository userRepository, 
                        ActorRepository actorRepository, CounterpartRepository counterpartRepository, ConfidentialityRepository confidentialityRepository) {
        this.legalCaseRepository = legalCaseRepository;
        this.instanceLegalCaseRepository = instanceLegalCaseRepository;
        this.instanceRepository = instanceRepository;
        this.userRepository = userRepository;
        this.actorRepository = actorRepository;
        this.counterpartRepository = counterpartRepository;
        this.confidentialityRepository = confidentialityRepository;
    }

    @Transactional
    public void saveLegalCase(LegalCaseDto legalCaseDto, Stack<String> pendingInvitations, String username, String ipAddress) {

        LegalCaseEntity legalCaseEntity = new LegalCaseEntity();
        ProvinceEntity province = new ProvinceEntity();
        DepartmentEntity department = new DepartmentEntity();
        UserEntity user = new UserEntity();
        PersonEntity person = new PersonEntity();
        CrimeEntity crime = new CrimeEntity();



        province.setProvinceId(Long.valueOf(legalCaseDto.getIdProvince()));
        province.setDepartment(department);
        user.setPersonId(person);
        crime.setCrimeId((long) legalCaseDto.getIdCrime());
        

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
        
        //legalCaseRepository.saveAndFlush(legalCaseEntity);
        // Register the initial instance on db
        
        
        InstanceLegalCaseEntity instanceCase= new InstanceLegalCaseEntity();
        InstanceEntity instance = new InstanceEntity();
        instance.setInstanceId((long) legalCaseDto.getIdInstance());
        instanceCase.setInstance(instance);
        instanceCase.setLegalCase(legalCaseEntity);
        instanceCase.setStartDate(legalCaseDto.getStartDateInstance());
        instanceCase.setEndDate(legalCaseDto.getEndDateInstance());
        instanceCase.setStatus(true);
        instanceLegalCaseRepository.saveAndFlush(instanceCase);

        
        
        // Send invitation to the user
       
        UserEntity userEntity = new UserEntity();
        String email="";

        for (int i = 0; i < pendingInvitations.size(); i++) {
            ActorEntity actor = new ActorEntity();        
            // Find the user by email
            email = pendingInvitations.get(i);        
            userEntity = userRepository.findByEmail(email);
            actor.setLegalCaseId(legalCaseEntity);
            actor.setUserId(userEntity);
            actor.setStatus(false);
            actorRepository.saveAndFlush(actor);
        }

        InstanceEntity savedInstance = instanceRepository.findById((long) legalCaseDto.getIdInstance()).orElse(null);
        if (savedInstance != null) {
            if(savedInstance.getInstanceName().equals("Instancia Preliminar")){
                Confidentiality confidentiality = confidentialityRepository.findByDescription("Público");
                legalCaseEntity.setConfidentiality(confidentiality);
                legalCaseRepository.saveAndFlush(legalCaseEntity);
        }
        if(savedInstance.getInstanceName().equals("Instancia de Investigación")){
            Confidentiality confidentiality = confidentialityRepository.findByDescription("Confidencial");
            legalCaseEntity.setConfidentiality(confidentiality);
            legalCaseRepository.saveAndFlush(legalCaseEntity);
        }
        if(savedInstance.getInstanceName().equals("Instancia de Sentencia")){
            Confidentiality confidentiality = confidentialityRepository.findByDescription("Restringido");
            legalCaseEntity.setConfidentiality(confidentiality);
            legalCaseRepository.saveAndFlush(legalCaseEntity);
        }
    }
        
        CounterpartEntity counterpart = new CounterpartEntity();
        counterpart.setLegalCaseId(legalCaseEntity);
        counterpart.setCounterpartName(legalCaseDto.getCounterpartName());
        counterpartRepository.saveAndFlush(counterpart);

        logBl.saveLog(username, "Se ha creado un caso con id: " +
                legalCaseEntity.getLegalCaseId(),
                1L, ipAddress, 1L);

    }

    public List<InstanceDto> findAllInstances(){
        List<InstanceEntity> instanceEntityList = instanceRepository.findAll();
        List<InstanceDto> instanceDtoList = new ArrayList<>();
        for (InstanceEntity instanceEntity : instanceEntityList) {
            InstanceDto instanceDto = new InstanceDto();
            instanceDto.setInstanceId(instanceEntity.getInstanceId());
            instanceDto.setInstanceName(instanceEntity.getInstanceName());
            instanceDtoList.add(instanceDto);
        }
        return instanceDtoList;
    }

    public Page<LegalCaseDto> findAllByUserIdWithFilters(Long userId, Date from, Date to, Long categoryId, Long instanceId, Boolean status, String title  ,Pageable pageable) {
        Specification<LegalCaseEntity> spec = Specification.where(LegalCaseSpecifications.hasUserId(userId));

        if (from != null && to != null) {
            spec = spec.and(LegalCaseSpecifications.startDateBetween(from, to));
        }

        if(instanceId!= null){
            spec = spec.and(LegalCaseSpecifications.hasInstance(instanceId));
        }

        if(categoryId!= null){
            spec = spec.and(LegalCaseSpecifications.hasCategory(categoryId));
        }

        if(status!= null){
            spec = spec.and(LegalCaseSpecifications.hasStatus(status));
        }

        if(title != null && !title.isEmpty()){
            spec = spec.and(LegalCaseSpecifications.titleContains(title));
        }

        Page<LegalCaseEntity> legalCasePage = legalCaseRepository.findAll(spec, pageable);
        return legalCasePage.map(this::convertToLegalCaseDto);
    }





    private LegalCaseDto convertToLegalCaseDto(LegalCaseEntity legalCaseEntity) {
        LegalCaseDto legalCaseDto = new LegalCaseDto();
        legalCaseDto.setIdLegalCase(legalCaseEntity.getLegalCaseId());
        legalCaseDto.setIdProvince(legalCaseEntity.getProvince().getProvinceId().intValue());
        legalCaseDto.setIdCrime(legalCaseEntity.getCrime().getCrimeId().intValue());
        legalCaseDto.setUserId(legalCaseEntity.getUser().getId().intValue());
        legalCaseDto.setStartDate(legalCaseEntity.getStartDate());
        legalCaseDto.setTitle(legalCaseEntity.getTitle());
        legalCaseDto.setSummary(legalCaseEntity.getSummary());
        legalCaseDto.setLastUpdate(legalCaseEntity.getTxDate());
        return legalCaseDto;
    }


    public void updateLegalCase(Long caseId, String username, String ipAddress) {
        LegalCaseEntity legalCaseEntity = legalCaseRepository.findById(caseId).orElse(null);
        legalCaseEntity.setStatus(false);
        legalCaseEntity.setTxDate(new Date());
        legalCaseRepository.save(legalCaseEntity);
        logBl.saveLog(username, "Se ha archivado el caso con id: " +
                legalCaseEntity.getLegalCaseId(),
                2L, ipAddress, 2L);
    }
    
    

    public CaseInformationDto getCaseInformationByCaseId(Long caseId) {
        CaseInformationDto caseInformationDto = new CaseInformationDto();
        List<String> caseInformation = legalCaseRepository.caseInformationByCaseId(caseId);
        String caseSummary = legalCaseRepository.caseSummaryByCaseId(caseId);
        if (!caseInformation.isEmpty()) {

            String[] elements = caseInformation.get(0).split(",");


            if (elements.length >= 6) {
                caseInformationDto.setProvinceName(elements[0].trim());
                caseInformationDto.setTitle(elements[1].trim());

                caseInformationDto.setUsername(elements[2].trim());
                caseInformationDto.setInstanceName(elements[3].trim());
                caseInformationDto.setTxDate(elements[4].trim());
                caseInformationDto.setSubCategoryName(elements[6].trim());
                caseInformationDto.setCrimeName(elements[5].trim());
                caseInformationDto.setSummary(caseSummary);

            }

        }

        return caseInformationDto;
    }

    public void updateInstanceLegalCase(Long caseId, InstanceLegalCaseDto instanceLegalCaseDto, String username, String ipAddress){
        LegalCaseEntity legalCaseEntity = legalCaseRepository.findById(caseId).orElse(null);
        InstanceEntity instanceEntity = instanceRepository.findById(instanceLegalCaseDto.getInstanceId()).orElse(null);
        List<InstanceLegalCaseEntity> instancePrevious = instanceLegalCaseRepository.getPreviousInstances(caseId);
        for (InstanceLegalCaseEntity instanceLegalCaseEntity : instancePrevious) {
            instanceLegalCaseEntity.setStatus(false);
            instanceLegalCaseRepository.save(instanceLegalCaseEntity);
        }
        InstanceLegalCaseEntity instanceLegalCaseEntity = new InstanceLegalCaseEntity();
        instanceLegalCaseEntity.setLegalCase(legalCaseEntity);
        instanceLegalCaseEntity.setInstance(instanceEntity);
        instanceLegalCaseEntity.setStatus(true);
        instanceLegalCaseEntity.setStartDate(instanceLegalCaseDto.getStartDate());
        instanceLegalCaseEntity.setEndDate(instanceLegalCaseDto.getEndDate());
        instanceLegalCaseRepository.saveAndFlush(instanceLegalCaseEntity);
        logBl.saveLog(username, "Se ha actualizado la instancia del caso con id: " +
                legalCaseEntity.getLegalCaseId(),
                2L, ipAddress, 2L);

        if(instanceLegalCaseDto.getInstanceId() == 1){
            Confidentiality confidentiality = confidentialityRepository.findByDescription("Público");
            legalCaseEntity.setConfidentiality(confidentiality);
            legalCaseRepository.saveAndFlush(legalCaseEntity);
        }
        if(instanceLegalCaseDto.getInstanceId() == 2){
            Confidentiality confidentiality = confidentialityRepository.findByDescription("Confidencial");
            legalCaseEntity.setConfidentiality(confidentiality);
            legalCaseRepository.saveAndFlush(legalCaseEntity);
        }
        if(instanceLegalCaseDto.getInstanceId() == 3){
            Confidentiality confidentiality = confidentialityRepository.findByDescription("Interna o Privada");
            legalCaseEntity.setConfidentiality(confidentiality);
            legalCaseRepository.saveAndFlush(legalCaseEntity);
        }   


    }

}
