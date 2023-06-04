package com.lawfinder.backend.api;

import com.lawfinder.backend.bl.CategoryBl;
import com.lawfinder.backend.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import com.lawfinder.backend.bl.LegalCaseBl;

import java.util.List;

@RestController
public class LegalCaseApi {
    @Autowired
    private LegalCaseBl legalCaseBl;
    @Autowired
    private CategoryBl categoryBl;
    @PostMapping("/api/v1/legalcase")
    public ResponseDto<String> createUser(@RequestBody LegalCaseDto legalcase /* , @RequestHeader("Authorization") String token*/) {
        ResponseDto<String> response = new ResponseDto<>();
       /*  AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            return response;
        }
        
        */
        System.out.println(legalcase.toString());
        this.legalCaseBl.saveLegalCase(legalcase);;
        response.setCode("0000");
        response.setResponse("Task created");
        return response;

        
    }

    @GetMapping("/api/v1/category/{id}/subcategory")
    public ResponseDto<List<SubCategoryDto>> getSubcategories(@PathVariable Long id /* , @RequestHeader("Authorization") String token*/) {
        ResponseDto<List<SubCategoryDto>> response = new ResponseDto<>();
       /*  AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            return response;
        }
        */
        //this.categoryBl.findAllSubCategoriesByCategoryId(id);
        response.setCode("0000");
        response.setResponse(this.categoryBl.findAllSubCategoriesByCategoryId(id));
        response.setErrorMessage(null);
        return response;

    }

    @GetMapping("/api/v1/legalcase/instance")
    public ResponseDto<List<InstanceDto>> getInstances( /* , @RequestHeader("Authorization") String token*/) {
        ResponseDto<List<InstanceDto>> response = new ResponseDto<>();
       /*  AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            return response;
        }
        */
        //this.categoryBl.findAllSubCategoriesByCategoryId(id);
        response.setCode("0000");
        response.setResponse(this.legalCaseBl.findAllInstances());
        response.setErrorMessage(null);
        return response;

    }

    
}
