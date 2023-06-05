package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.InstanceLegalCaseEntity;
import com.lawfinder.backend.dao.InstanceLegalCaseRepository;
import com.lawfinder.backend.dto.InstanceLegalCaseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstanceLegalCaseBl {
    private InstanceLegalCaseRepository instanceLegalCaseRepository;

    public InstanceLegalCaseBl(InstanceLegalCaseRepository instanceLegalCaseRepository) {
        this.instanceLegalCaseRepository = instanceLegalCaseRepository;
    }

    public List<InstanceLegalCaseDto>findAll(){
        List<InstanceLegalCaseEntity> instanceLegalCaseEntityList = instanceLegalCaseRepository.findAll();
        List<InstanceLegalCaseDto> instanceLegalCaseDtoList = new ArrayList<>();

        for (InstanceLegalCaseEntity instanceLegalCaseEntity : instanceLegalCaseEntityList) {
            InstanceLegalCaseDto instanceLegalCaseDto = new InstanceLegalCaseDto();

            instanceLegalCaseDto.setInstanceLegalCaseId(instanceLegalCaseEntity.getInstanceLegalCaseId());
            instanceLegalCaseDto.setInstanceId(instanceLegalCaseEntity.getInstance().getInstanceId());
            instanceLegalCaseDto.setLegalCaseId(instanceLegalCaseEntity.getLegalCase().getLegalCaseId());
            instanceLegalCaseDto.setStartDate(instanceLegalCaseEntity.getStartDate());
            instanceLegalCaseDtoList.add(instanceLegalCaseDto);
        }
        return instanceLegalCaseDtoList;
    }
}
