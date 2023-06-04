package com.lawfinder.backend.api;
import com.lawfinder.backend.bl.InstanceLegalCaseBl;
import com.lawfinder.backend.dto.InstanceLegalCaseDto;
import com.lawfinder.backend.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
