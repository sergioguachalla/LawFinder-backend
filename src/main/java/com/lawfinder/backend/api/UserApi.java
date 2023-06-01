package com.lawfinder.backend.api;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.lawfinder.backend.bl.*;
import com.lawfinder.backend.dto.*;
@CrossOrigin(origins = "*")

@RestController
public class UserApi {
    @Autowired
    private UserBl userBl;
    @Autowired
    private PersonBl personBl;
    // Constructor

    public UserApi(UserBl userBl, PersonBl personBl) {
        this.userBl = userBl;
        this.personBl = personBl;
    }

    @PostMapping("/api/v1/user")
    public ResponseDto<String> createUser(@RequestBody UserDto user) {
        ResponseDto<String> response = new ResponseDto<>();
        System.out.println(user.toString());
        this.userBl.saveUser(user);;
        response.setCode("0000");
        response.setResponse("user created");
        return response;

        
    }

    @PostMapping("/api/v1/sendmail")
    public ResponseDto<String> sendMail(@RequestBody MailDto mail) {
        ResponseDto<String> response = new ResponseDto<>();
        this.userBl.sendmail(mail);
        response.setCode("0000");
        response.setResponse("mail sended");
        return response;
   
    }

    @PostMapping("/api/v1/verify")
    public ResponseDto<String> verifyMail(@RequestBody VerifyDto mail) {
        ResponseDto<String> response = new ResponseDto<>();
        if(this.userBl.verify(mail)){
            response.setCode("0000");
            response.setResponse("mail verified");
        }else{
            response.setCode("0001");
            response.setResponse("mail not verified");
        }
        return response;
   
    }





}
