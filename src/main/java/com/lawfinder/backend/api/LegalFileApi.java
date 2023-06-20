package com.lawfinder.backend.api;
import com.lawfinder.backend.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.lawfinder.backend.bl.LegalFileBl;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class LegalFileApi {

    @Autowired
    private LegalFileBl s3Service;;

    @PostMapping("/api/v1/legalfile")
    public void upload(@RequestParam("file") MultipartFile file,
                     @RequestParam("instanceCaseId") Integer instanceCaseId,
                     @RequestParam("summary") String summary,
                     @RequestParam("dueDate") String dueDate,
                     @RequestParam("courtId") Integer courtId,
                     @RequestParam("documentTypeId") Integer documentTypeId){
    s3Service.saveFile(file, instanceCaseId, summary, dueDate, courtId, documentTypeId);
}
    @GetMapping("/api/v1/case/{caseId}/files")
    public ResponseDto<List<String>> getFiles(@PathVariable("caseId") Long caseId){
        ResponseDto<List<String>> responseDto = new ResponseDto<>();
        List<String> files = s3Service.findByCaseId(caseId);
        responseDto.setCode("0000");
        responseDto.setResponse(files);
        responseDto.setErrorMessage(null);
        return responseDto;
    }

    @GetMapping("/api/v1/case/{caseId}/instance/{instanceName}")
    public ResponseDto<List<String[]>> getFilesByInstance(@PathVariable("caseId") Long caseId, @PathVariable("instanceName") String instanceName){
        ResponseDto<List<String[]>> responseDto = new ResponseDto<>();
        List<String[]> files = s3Service.findByCaseIdAndInstanceName(caseId, instanceName);
        responseDto.setCode("0000");
        responseDto.setResponse(files);
        responseDto.setErrorMessage(null);
        return responseDto;
    }

}