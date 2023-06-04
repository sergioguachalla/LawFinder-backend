package com.lawfinder.backend.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.lawfinder.backend.bl.AwsS3Bl;

import java.util.List;

import static java.net.HttpURLConnection.HTTP_OK;

@CrossOrigin(origins = "*")

@RestController
public class LegalFileApi {

    @Autowired
    private AwsS3Bl s3Service;;

    /* 
    @PostMapping("/api/v1/file")
    public ResponseDto<String> createFile(@RequestBody FileDto file , @RequestHeader("Authorization") String token) {
        ResponseDto<String> response = new ResponseDto<>();
         AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            return response;
        }
        

        System.out.println(file.toString());
        this.fileBl.saveFile(file);;
        response.setCode("0000");
        response.setResponse("Task created");
        return response;
    }
    */

        @PostMapping("upload")
        public String upload(@RequestParam("file") MultipartFile file){
        return s3Service.saveFile(file);
        }

    @GetMapping("download/{filename}")
    public ResponseEntity<byte[]> download(@PathVariable("filename") String filename){
        HttpHeaders headers=new HttpHeaders();
        headers.add("Content-type", MediaType.ALL_VALUE);
        headers.add("Content-Disposition", "attachment; filename="+filename);
        byte[] bytes = s3Service.downloadFile(filename);
        return  ResponseEntity.status(HTTP_OK).headers(headers).body(bytes);
    }


    @DeleteMapping("{filename}")
    public  String deleteFile(@PathVariable("filename") String filename){
       return s3Service.deleteFile(filename);
    }

    @GetMapping("list")
    public List<String> getAllFiles(){

        return s3Service.listAllFiles();

    }
    
}
