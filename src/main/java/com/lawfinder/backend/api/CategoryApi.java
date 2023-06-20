package com.lawfinder.backend.api;
import com.lawfinder.backend.bl.AuthBl;
import com.lawfinder.backend.bl.CategoryBl;
import com.lawfinder.backend.dao.InstanceLegalCaseRepository;
import com.lawfinder.backend.dao.UserRepository;
import com.lawfinder.backend.dao.UserRoleRepository;
import com.lawfinder.backend.dto.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@CrossOrigin(origins = "*")
@RestController
public class CategoryApi {
    @Autowired
    AuthBl authBl;
    @Autowired
    CategoryBl categoryBl;

    @GetMapping("/api/v1/category")
    public ResponseDto<List<CategoryDto>> getAllCategory(/*@RequestHeader("Authorization")*/ String token){
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
        ResponseDto<List<CategoryDto>> response = new ResponseDto<>();
        response.setCode("0000");
        response.setResponse(this.categoryBl.findAll());
        return response;  

    }

}
