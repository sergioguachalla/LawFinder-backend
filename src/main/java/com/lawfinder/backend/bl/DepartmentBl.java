package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.DepartmentEntity;
import com.lawfinder.backend.Entity.ProvinceEntity;
import com.lawfinder.backend.dao.DepartmentRepository;
import com.lawfinder.backend.dto.DepartmentDto;

import com.lawfinder.backend.dto.ProvinceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentBl {
    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentBl(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    public DepartmentEntity saveDepartment(DepartmentEntity departmentEntity){
        return departmentRepository.save(departmentEntity);
    }

    public List<DepartmentDto> findAll(){
        
        List<DepartmentEntity> Department = departmentRepository.findAll();
        List<DepartmentDto> res = new ArrayList<>();
        
        Department.forEach(task -> {
            res.add(new DepartmentDto(task.getDepartmentId(), task.getName()));
        });
        return res;

    }

    public List<DepartmentEntity> findByDepartmentId(Long departmentId){
        return departmentRepository.findByDepartmentId(departmentId);
    }

    public DepartmentDto findById(Long departmentId){
        DepartmentEntity departmentEntity = departmentRepository.findById(departmentId).orElse(null);
        if(departmentEntity == null){
            return null;
        }
        return new DepartmentDto(departmentEntity.getDepartmentId(), departmentEntity.getName());
    }

    public List<ProvinceDto> findProvinceByDepartmentId(Long departmentId){
        List<ProvinceEntity> provincesList =  departmentRepository.findProvinceByDepartmentId(departmentId);
        List<ProvinceDto> provinceDtoList = new ArrayList<>();
        provincesList.forEach(province -> {
            ProvinceDto provinceDto = new ProvinceDto(province.getProvinceId(), province.getProvinceName(), province.getDepartment().getDepartmentId());
            provinceDtoList.add(provinceDto);
        });
        return provinceDtoList;
    }

}
