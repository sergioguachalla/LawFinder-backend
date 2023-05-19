package com.lawfinder.backend;

import com.lawfinder.backend.Entity.DepartmentEntity;
import com.lawfinder.backend.bl.DepartmentBl;
import com.lawfinder.backend.dao.DepartmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BackendApplicationTests {

	@Autowired
	private DepartmentRepository departmentRepository;
	@Test
	void contextLoads() {
	}

	@Test
	public void createDepartment(){
		DepartmentEntity department = new DepartmentEntity();
		department.setName("La Paz");
		DepartmentEntity newDepartment = departmentRepository.saveAndFlush(department);
		assertNotNull(newDepartment, "No se pudo crear el departamento");
		assertNotNull(newDepartment.getDepartmentId(),"La llave primaria ees nula");



	}

	


	

}
