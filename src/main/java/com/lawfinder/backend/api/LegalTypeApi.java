package com.lawfinder.backend.api;

import com.lawfinder.backend.bl.LegalFileTypeBl;
import com.lawfinder.backend.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")

@RestController
public class LegalTypeApi {

    @Autowired
    private LegalFileTypeBl LegalFileTypeBl;
    @GetMapping("/api/v1/LegalType")
    public ResponseDto<List<LegalFileTypeDto>> getAllFileTypes(/*@RequestHeader("Authorization")*/ String token){
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

        ResponseDto<List<LegalFileTypeDto>> response = new ResponseDto<>();
        response.setCode("0000");
        response.setResponse(this.LegalFileTypeBl.findAll());
        return response;  

    }
    
}
