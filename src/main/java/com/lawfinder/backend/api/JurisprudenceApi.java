package com.lawfinder.backend.api;

import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import com.lawfinder.backend.bl.DepartmentBl;
import com.lawfinder.backend.dto.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lawfinder.backend.bl.*;

@RestController
public class JurisprudenceApi {
    @Autowired
    private JurisprudenceBl jurispeudenceBl;
    @PostMapping("/api/v1/jurisprudence")
    public ResponseDto<String> createJurisprudence(@RequestBody JurisprudenceDto juris /* , @RequestHeader("Authorization") String token*/) {
        ResponseDto<String> response = new ResponseDto<>();
       /*  AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            return response;
        }
        
        */
        System.out.println(juris.toString());
        this.jurispeudenceBl.saveJurisprudence(juris);
        response.setCode("0000");
        response.setResponse("Task created");
        return response;

        
    }

    
}
