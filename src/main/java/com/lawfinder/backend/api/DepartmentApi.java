package com.lawfinder.backend.api;
import java.util.*;
import org.springframework.web.bind.annotation.*;
import com.lawfinder.backend.bl.AuthBl;
import com.lawfinder.backend.bl.DepartmentBl;
import com.lawfinder.backend.dto.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentApi {
    private DepartmentBl departmentBl;

    public DepartmentApi(DepartmentBl departmentBl){
        this.departmentBl = departmentBl;
    }

    @GetMapping("/api/v1/department")
    public ResponseDto<List<DepartmentDto>> getAllDepartments(){  
        /* 
        AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            ResponseDto<List<DepartmentDto>> response = new ResponseDto<>();
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            return response;
        }
        */
        ResponseDto<List<DepartmentDto>> response = new ResponseDto<>();
        response.setCode("0000");
        response.setResponse(this.departmentBl.findAll());
        return response;  

    }
    
}
