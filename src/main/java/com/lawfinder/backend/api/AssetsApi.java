package com.lawfinder.backend.api;

import java.util.Date;
import java.util.List;

import com.lawfinder.backend.bl.AuthBl;
import com.lawfinder.backend.bl.LogBl;
import com.lawfinder.backend.dto.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.lawfinder.backend.bl.InformationAssetsClassificationBl;
@CrossOrigin(origins = "*")

@RestController

@RequestMapping("/api/v1/informationAssets")
public class AssetsApi {

   @Autowired
   InformationAssetsClassificationBl informationAssetsClassificationBl;
   @Autowired
   AuthBl authBl;
   @Autowired
   LogBl logBl;

   @GetMapping("")
   public ResponseDto<List<InformationAssetDto>> getInformationAssets() {
      ResponseDto<List<InformationAssetDto>> response = new ResponseDto<>();
      response.setCode("0000");
      response.setErrorMessage("Success");
      response.setResponse(informationAssetsClassificationBl.findAllInformationAssets());
      return response;

   }

   @GetMapping("/all")
   public ResponseDto<Page<ConfidentialCaseDto>> getConfidentiality(
           @RequestParam(required = false) Long confidentialityId,
           @RequestParam(defaultValue = "0") int page,
           @RequestParam(defaultValue = "10") int size,
           @RequestHeader("Authorization") String token,
           HttpServletRequest request
   ){
      ResponseDto<Page<ConfidentialCaseDto>> response = new ResponseDto<>();
        String ipAddress = authBl.getClientIp(request);
        if(!authBl.validateToken(token)){
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            logBl.saveSecurityLog("desconocido", "Intento de acceso a reporte de activos no autorizado", ipAddress,6L);
            return response;
        }
        Pageable pageable = PageRequest.of(page, size);
        response.setCode("0000");
        response.setResponse(informationAssetsClassificationBl.findAllConfidentialCases(pageable, confidentialityId));
        response.setErrorMessage(null);
        return response;
   }

   @GetMapping("/category")
   public ResponseDto<List<ConfidentialityDto>> getInformationAssetsCategory() {
      ResponseDto<List<ConfidentialityDto>> response = new ResponseDto<>();
      response.setCode("0000");
      response.setErrorMessage("Success");
      response.setResponse(informationAssetsClassificationBl.getAllConfidentialities());
      return response;

   }
   
}
