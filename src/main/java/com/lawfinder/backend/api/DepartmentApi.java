package com.lawfinder.backend.api;
import java.util.*;

import com.lawfinder.backend.bl.AuthBl;
import org.springframework.beans.factory.annotation.Autowired;
import com.lawfinder.backend.bl.DepartmentBl;
import com.lawfinder.backend.dto.*;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*")

@RestController
public class DepartmentApi {
    @Autowired
    private DepartmentBl departmentBl;
    @Autowired
    private AuthBl authBl;

    /*public DepartmentApi(DepartmentBl departmentBl){
        this.departmentBl = departmentBl;
    }*/

    @GetMapping("/api/v1/department")
    public ResponseDto<List<DepartmentDto>> getAllDepartments(/*@RequestHeader("Authorization")*/ String token){
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

    @GetMapping("/api/v1/department/{idDepartment}")
    public ResponseDto<DepartmentDto> getDepartmentById(@RequestHeader("Authorization") String token, @PathVariable Long idDepartment){


        if (!authBl.validateToken(token)) {
            ResponseDto<DepartmentDto> response = new ResponseDto<>();
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            return response;
        }

        ResponseDto<DepartmentDto> response = new ResponseDto<>();
        response.setCode("0000");
        response.setResponse(this.departmentBl.findById(idDepartment));
        return response;

    }

    @GetMapping("/api/v1/department/{idDepartment}/province")
    public ResponseDto<List<ProvinceDto>> getProvincesByDepartment(/*@RequestHeader("Authorization") String token ,*/ @PathVariable Long idDepartment){
        /* 
        AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            ResponseDto<List<ProvinceDto>> response = new ResponseDto<>();
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            return response;
        }
        */

        ResponseDto<List<ProvinceDto>> response = new ResponseDto<>();
        response.setCode("0000");
        response.setResponse(this.departmentBl.findProvinceByDepartmentId(idDepartment));
        return response;

    }



    
}
