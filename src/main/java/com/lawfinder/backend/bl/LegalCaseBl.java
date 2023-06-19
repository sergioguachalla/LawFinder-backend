package com.lawfinder.backend.bl;
import com.lawfinder.backend.Entity.*;
import com.lawfinder.backend.dao.*;
import com.lawfinder.backend.dto.*;
import com.lawfinder.backend.specifications.LegalCaseSpecifications;

import org.apache.tomcat.util.http.fileupload.MultipartStream.ProgressNotifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import java.util.Date;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;


@Service
public class LegalCaseBl {
    @Autowired
    private final LegalCaseRepository legalCaseRepository;
    private final InstanceLegalCaseRepository instanceLegalCaseRepository;
    private final InstanceRepository instanceRepository;
    private final UserRepository userRepository;
    private final ActorRepository actorRepository;
    private final CounterpartRepository counterpartRepository;

    @Autowired
    private CrimeRepository crimeRepository;

    public LegalCaseBl(LegalCaseRepository legalCaseRepository, InstanceLegalCaseRepository instanceLegalCaseRepository, 
                        InstanceRepository instanceRepository, UserRepository userRepository, ActorRepository actorRepository, CounterpartRepository counterpartRepository) {
        this.legalCaseRepository = legalCaseRepository;
        this.instanceLegalCaseRepository = instanceLegalCaseRepository;
        this.instanceRepository = instanceRepository;
        this.userRepository = userRepository;
        this.actorRepository = actorRepository;
        this.counterpartRepository = counterpartRepository;
    }

    @Transactional
    public void saveLegalCase(LegalCaseDto legalCaseDto, Stack<String> pendingInvitations) {
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

        
        
        // Send invitation to the user
       
        UserEntity userEntity = new UserEntity();
        String email="";
        System.out.println("#######################################################");
        System.out.println(pendingInvitations.size());
        System.out.println("#######################################################");


        for (int i = 0; i < pendingInvitations.size(); i++) {
            ActorEntity actor = new ActorEntity();
            System.out.println("9999999999999999999999999999999999999");
        
            // Find the user by email
            email = pendingInvitations.get(i); // Accede al elemento en la posición i sin extraerlo de la pila
            System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
            System.out.println(email);
            System.out.println("Iteracion: "+i);
            System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
        
            userEntity = userRepository.findByEmail(email);
            actor.setLegalCaseId(legalCaseEntity);
            actor.setUserId(userEntity);
            actor.setStatus(false);
            actorRepository.saveAndFlush(actor);
        }
        
        CounterpartEntity counterpart = new CounterpartEntity();
        counterpart.setLegalCaseId(legalCaseEntity);
        counterpart.setCounterpartName(legalCaseDto.getCounterpartName());
        counterpartRepository.saveAndFlush(counterpart);


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

   /*public List<LegalCaseDto> findAllByUserId(Long userId){
        List<LegalCaseDto> legalCaseDtoList = new ArrayList<>();
        List<LegalCaseEntity> legalCaseEntityList = legalCaseRepository.findAllByUserId(userId, pageable);
        for (LegalCaseEntity legalCaseEntity : legalCaseEntityList) {
            LegalCaseDto legalCaseDto = new LegalCaseDto();
            legalCaseDto.setIdLegalCase(legalCaseEntity.getLegalCaseId());
            legalCaseDto.setIdProvince(legalCaseEntity.getProvince().getProvinceId().intValue());
            legalCaseDto.setIdCrime(legalCaseEntity.getCrime().getCrimeId().intValue());
            legalCaseDto.setUserId(legalCaseEntity.getUser().getId().intValue());
            legalCaseDto.setStartDate(legalC    aseEntity.getStartDate());
            legalCaseDto.setTitle(legalCaseEntity.getTitle());
            legalCaseDto.setSummary(legalCaseEntity.getSummary());
            legalCaseDto.setLastUpdate(legalCaseEntity.getTxDate());
            legalCaseDtoList.add(legalCaseDto);
        }
        return legalCaseDtoList;
    }*/

    /* 
    public Page<LegalCaseDto> findAllByUserIdPaginated(Long userId, Pageable pageable) {
        Page<LegalCaseEntity> legalCasePage = legalCaseRepository.findAllByUserId(userId, pageable);
        return legalCasePage.map(this::convertToLegalCaseDto);
    }

    public Page<LegalCaseDto> findAllByUserIdAndStartDateBetween(Long userId, Date from, Date to, Pageable pageable) {
        Page<LegalCaseEntity> legalCasePage = legalCaseRepository.findAllByUserIdAndStartDateBetween(userId, from, to, pageable);
        return legalCasePage.map(this::convertToLegalCaseDto);
    }
    */

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


    public void updateLegalCase(Long caseId){
        LegalCaseEntity legalCaseEntity = legalCaseRepository.findById(caseId).orElse(null);
        legalCaseEntity.setStatus(false);
        legalCaseRepository.save(legalCaseEntity);
    }
    
    

    public CaseInformationDto getCaseInformationByCaseId(Long caseId) {
        CaseInformationDto caseInformationDto = new CaseInformationDto();
        List<String> caseInformation = legalCaseRepository.caseInformationByCaseId(caseId);
        String caseSummary = legalCaseRepository.caseSummaryByCaseId(caseId);
        System.out.println("caseInformation: " + caseInformation);
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

}
