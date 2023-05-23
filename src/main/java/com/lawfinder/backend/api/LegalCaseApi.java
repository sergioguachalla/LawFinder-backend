package com.lawfinder.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lawfinder.backend.bl.LegalCaseBl;
import com.lawfinder.backend.dto.LegalCaseDto;
import com.lawfinder.backend.dto.ResponseDto;

@RestController
public class LegalCaseApi {
    @Autowired
    private LegalCaseBl legalCaseBl;
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

    
}
