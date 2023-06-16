package com.lawfinder.backend.api;

import com.lawfinder.backend.bl.CategoryBl;
import com.lawfinder.backend.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import com.lawfinder.backend.bl.LegalCaseBl;
import com.lawfinder.backend.bl.UserBl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

@CrossOrigin(origins = "*")
@RestController
public class LegalCaseApi {
    @Autowired
    private LegalCaseBl legalCaseBl;
    
    @Autowired
    private CategoryBl categoryBl;

    @Autowired
    private UserBl registrationBl;

    private Stack<String> pendingInvitations = new Stack<>();
    Set<Integer> conjunto = new HashSet<>();
    


    


    @PostMapping("/api/v1/userverification")
    public ResponseDto<String> getVerification(@RequestBody DeviceIdDto deviceIdDto){
        ResponseDto<String> response = new ResponseDto<>();
        if(this.registrationBl.verifyUserByEmail(deviceIdDto)){
            System.out.println(deviceIdDto.getEmail());
            pendingInvitations.push(deviceIdDto.getEmail());
            response.setCode("0001");
            response.setResponse("User Already Exists");
            response.setErrorMessage(null);
        }
        else{
            response.setCode("0000");
            response.setResponse("User Does Not Exist");
            response.setErrorMessage(null);
        }

        return response;

    }
    
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
        this.legalCaseBl.saveLegalCase(legalcase,pendingInvitations);
        response.setCode("0000");
        response.setResponse("Task created");
        pendingInvitations.clear();

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

    @GetMapping("/api/v1/category")
    public ResponseDto<List<CategoryDto>> getCategories( /* , @RequestHeader("Authorization") String token*/) {
        ResponseDto<List<CategoryDto>> response = new ResponseDto<>();
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
        response.setResponse(this.categoryBl.findAll());
        response.setErrorMessage(null);
        return response;

    }

    /*@GetMapping("/api/v1/legalcase/user/{id}")
    public ResponseDto<List<LegalCaseDto>> getLegalCasesByUserId(@PathVariable Long id  /* , @RequestHeader("Authorization") String token*/
    //)

    //{
        //ResponseDto<List<LegalCaseDto>> response = new ResponseDto<>();
       /*  AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            return response;
        }
        */
        //this.categoryBl.findAllSubCategoriesByCategoryId(id);
        /*response.setCode("0000");
        response.setResponse(this.legalCaseBl.findAllByUserId(id));
        response.setErrorMessage(null);
        return response;

    }
    @GetMapping("/api/v1/legalcase/user/{id}")
        public ResponseDto<Page<LegalCaseDto>> getLegalCasesByUserId(
            @PathVariable Long id,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size){
        ResponseDto<Page<LegalCaseDto>> response = new ResponseDto<>();

        Pageable pageable = PageRequest.of(page, size);
        Page<LegalCaseDto> legalCasesPage = this.legalCaseBl.findAllByUserIdPaginated(id, pageable);

        response.setCode("0000");
        response.setResponse(legalCasesPage);
        response.setErrorMessage(null);
        return response;
    }*/

    @GetMapping("/api/v1/legalcase/user/{id}")
    public ResponseDto<Page<LegalCaseDto>> getLegalCasesByUserId(
            @PathVariable Long id,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date to,
            @RequestParam(required = false) Long crimeId,
            @RequestParam(required = false) Long instanceId,
            @RequestParam(required = false) Boolean inProgress,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){

        ResponseDto<Page<LegalCaseDto>> response = new ResponseDto<>();
        Pageable pageable = PageRequest.of(page, size);
        Page<LegalCaseDto> legalCasesPage = legalCaseBl.findAllByUserIdWithFilters(id, from, to, crimeId, instanceId, inProgress ,pageable);
        System.out.println("###########################################");
        System.out.println(inProgress);
        System.out.println("###########################################");
        response.setCode("0000");
        response.setResponse(legalCasesPage);
        response.setErrorMessage(null);
        return response;
    }

    @PutMapping("/api/v1/legalcase/{id}")
    public ResponseDto<String> updateLegalCase(@PathVariable Long id/* , @RequestHeader("Authorization") String token*/) {
        ResponseDto<String> response = new ResponseDto<>();
       /*  AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            return response;
        }
        */
        this.legalCaseBl.updateLegalCase(id);
        response.setCode("0000");
        response.setResponse("Task updated");
        response.setErrorMessage(null);
        return response;
    }


}





