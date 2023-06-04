package com.lawfinder.backend.api;

import com.lawfinder.backend.bl.CrimeBl;
import com.lawfinder.backend.dto.CrimeDto;
import com.lawfinder.backend.dto.ResponseDto;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CrimeApi {
    @Autowired
    private CrimeBl crimeBl;
    @GetMapping("/api/v1/subcategory/{id}/crime")
    public ResponseDto<List<CrimeDto>> crimesBySubcategoryId(@PathVariable Long id) {
        ResponseDto<List<CrimeDto>> responseDto = new ResponseDto<>();
        responseDto.setCode("0000");
        responseDto.setResponse(crimeBl.getCrimesBySubcategoryId(id));
        responseDto.setErrorMessage(null);
        return responseDto;

    }

    }

