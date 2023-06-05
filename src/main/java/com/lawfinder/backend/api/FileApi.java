/*package com.lawfinder.backend.api;
import java.util.*;

import com.lawfinder.backend.Entity.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import com.lawfinder.backend.dto.*;
import org.springframework.web.bind.annotation.*;
import com.lawfinder.backend.bl.*;

@RestController
public class FileApi {
    @Autowired
    private FileBl fileBl;

    public FileApi(FileBl fileBl){
        this.fileBl = fileBl;
    }

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

    @GetMapping("/api/v1/file")
    public ResponseDto<List<FileDto>> getFiles(@RequestHeader("Authorization") String token) {
        ResponseDto<List<FileDto>> response = new ResponseDto<>();
        AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            return response;
        }
        List<FileDto> filesDtoList = this.fileBl.findAll();
        response.setCode("0000");
        response.setResponse(filesDtoList);
        return response;
    }

    @GetMapping("/api/v1/file/{idFile}")
    public ResponseDto<FileDto> getFileById(@RequestHeader("Authorization") String token, @PathVariable Long idFile) {
        ResponseDto<FileDto> response = new ResponseDto<>();
        AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            return response;
        }
        FileDto fileDto = this.fileBl.findById(idFile);


        response.setCode("0000");
        response.setResponse(fileDto);
        return response;
    }



    
} */
