package com.lawfinder.backend.api;
import com.lawfinder.backend.dto.FileQueryDto;
import com.lawfinder.backend.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.lawfinder.backend.bl.LegalFileBl;

import java.util.List;

import static java.net.HttpURLConnection.HTTP_OK;

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




}