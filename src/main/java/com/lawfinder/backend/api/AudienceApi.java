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

    @GetMapping("/api/v1/audience/user/{idUser}")
    public ResponseDto<List<AudienceDto>> getAudiencesByIdCase(/*@RequestHeader("Authorization") String token ,*/ @PathVariable Long id){
        /* 
        AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            ResponseDto<DepartmentDto> response = new ResponseDto<>();
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            return response;
        }
        */
        

        ResponseDto<List<AudienceDto>> response = new ResponseDto<>();
        response.setCode("0000");
        //response.setResponse(this.audienceBl.findByuserId(id));
        response.setErrorMessage(null);
        return response;

    }

   
    @PostMapping("/api/v1/legalcase/{idCase}/audience")
    public ResponseDto<String> createAudience(@PathVariable Long idCase, @RequestBody AudienceDto audienceDto){
        ResponseDto<String> response = new ResponseDto<>();
        this.audienceBl.saveAudience(idCase, audienceDto);
        response.setCode("0000");
        response.setResponse("Audiencia creada");
        response.setErrorMessage(null);
        return response;

    }
    
}
