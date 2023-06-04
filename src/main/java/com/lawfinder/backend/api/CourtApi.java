package com.lawfinder.backend.api;


import com.lawfinder.backend.bl.CourtBl;
import com.lawfinder.backend.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")

@RestController
public class CourtApi {
    @Autowired
    private CourtBl CourtBl;
    @GetMapping("/api/v1/Court")
    public ResponseDto<List<CourtDto>> getAllCourt(/*@RequestHeader("Authorization")*/ String token){
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

        ResponseDto<List<CourtDto>> response = new ResponseDto<>();
        response.setCode("0000");
        response.setResponse(this.CourtBl.findAll());
        return response;  

    }

    
}
