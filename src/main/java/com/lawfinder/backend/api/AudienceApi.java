package com.lawfinder.backend.api;
import java.util.*;

import com.lawfinder.backend.bl.AuthBl;
import org.springframework.beans.factory.annotation.Autowired;
import com.lawfinder.backend.bl.AudienceBl;
import com.lawfinder.backend.dto.*;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*")

@RestController
public class AudienceApi {
    @Autowired
    private AudienceBl audienceBl;

    /* 
    @GetMapping("/api/v1/legalcase/{idCase}/audience")
    public ResponseDto<List<AudienceDto>> getAudiencesByIdCase(@RequestHeader("Authorization") String token, @PathVariable Long idCase){
    
        AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            ResponseDto<DepartmentDto> response = new ResponseDto<>();
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            return response;
        }
        

        ResponseDto<List<AudienceDto>> response = new ResponseDto<>();
        response.setCode("0000");
        response.setResponse(this.audienceBl.findByLegalCaseId(idCase));
        response.setErrorMessage(null);
        return response;

    }*/
    
}
