package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.DepartmentEntity;
import com.lawfinder.backend.dao.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentBl {
    private final DepartmentRepository departmentRepository;
    public DepartmentBl(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    public DepartmentEntity saveDepartment(DepartmentEntity departmentEntity){
        return departmentRepository.save(departmentEntity);
    }

    public List<DepartmentEntity> findAll(){
        return departmentRepository.findAll();
    }

    public List<DepartmentEntity> findByDepartmentId(Long departmentId){
        return departmentRepository.findByDepartmentId(departmentId);
    }

}
