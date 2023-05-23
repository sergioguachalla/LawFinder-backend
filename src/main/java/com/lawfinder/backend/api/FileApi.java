package com.lawfinder.backend.api;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import com.lawfinder.backend.bl.DepartmentBl;
import com.lawfinder.backend.dto.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lawfinder.backend.bl.*;

@RestController
public class FileApi {
    @Autowired
    private FileBl fileBl;

    public FileApi(FileBl fileBl){
        this.fileBl = fileBl;
    }

    @PostMapping("/api/v1/file")
    public ResponseDto<String> createFile(@RequestBody FileDto file /* , @RequestHeader("Authorization") String token*/) {
        ResponseDto<String> response = new ResponseDto<>();
       /*  AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            return response;
        }
        
        */
        System.out.println(file.toString());
        this.fileBl.saveFile(file);;
        response.setCode("0000");
        response.setResponse("Task created");
        return response;

        
    }



    
}
