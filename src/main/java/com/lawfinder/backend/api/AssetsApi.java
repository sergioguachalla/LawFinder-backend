package com.lawfinder.backend.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lawfinder.backend.dto.InformationAssetDto;
import com.lawfinder.backend.dto.ResponseDto;
import com.lawfinder.backend.bl.InformationAssetsClassificationBl;

@RestController
@RequestMapping("/api/v1/informationAssets")
public class AssetsApi {

   @Autowired
   InformationAssetsClassificationBl informationAssetsClassificationBl;

   @GetMapping("")
   public ResponseDto<List<InformationAssetDto>> getInformationAssets() {
      ResponseDto<List<InformationAssetDto>> response = new ResponseDto<>();
      response.setCode("0000");
      response.setErrorMessage("Success");
      response.setResponse(informationAssetsClassificationBl.findAllInformationAssets());
      return response;

   }
   
}
