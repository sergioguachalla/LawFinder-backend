package com.lawfinder.backend.api;
import com.lawfinder.backend.bl.InstanceLegalCaseBl;
import com.lawfinder.backend.dto.InstanceDto;
import com.lawfinder.backend.dto.InstanceLegalCaseDto;
import com.lawfinder.backend.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController

public class InstanceLegalApi {
    @Autowired
    private InstanceLegalCaseBl instanceLegalCaseBl;

    @GetMapping("/api/v1/instanceLegal")
    public ResponseDto<List<InstanceLegalCaseDto>> getAllInstanceLegals(//@RequestHeader("Authorization") String
                                                                        ){
        ResponseDto<List<InstanceLegalCaseDto>> response = new ResponseDto<>();
        response.setCode("0000");
        response.setResponse(this.instanceLegalCaseBl.findAll());
        response.setErrorMessage(null);
        return response;
    }

    @GetMapping("/api/v1/instanceLegal/{legalCaseId}")
    public ResponseDto<InstanceLegalCaseDto> getInstanceLegalById(@PathVariable Long legalCaseId){
        ResponseDto<InstanceLegalCaseDto> response = new ResponseDto<>();
        response.setCode("0000");
        response.setResponse(this.instanceLegalCaseBl.findByInstanceLegalCaseId(legalCaseId));
        response.setErrorMessage(null);
        return response;
    }
}
