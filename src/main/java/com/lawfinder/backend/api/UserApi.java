package com.lawfinder.backend.api;

import com.lawfinder.backend.Entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lawfinder.backend.bl.*;
import com.lawfinder.backend.dto.*;

import java.util.List;

@CrossOrigin(origins = "*")

@RestController
public class UserApi {
    @Autowired
    private UserBl userBl;
    // Constructor

    public UserApi(UserBl userBl) {
        this.userBl = userBl;
    }

    @PostMapping("/api/v1/user")
    public ResponseDto<String> createUser(@RequestBody UserDto user) {
        ResponseDto<String> response = new ResponseDto<>();
        this.userBl.saveCustomer(user);
        PersonEntity person = new PersonEntity();
        person.setEmail(user.getPersonId().getEmail());
        MailDto mail = new MailDto();
        mail.setMail(user.getPersonId().getEmail());
        //this.userBl.sendmail(mail);
        response.setCode("0000");
        response.setResponse("user created");
        return response;

        
    }
    
    @PostMapping("/api/v1/lawyer")
    public ResponseDto<String> createLawyer(@RequestBody UserDto lawyer){
        ResponseDto<String> response = new ResponseDto<>();
        this.userBl.saveLawyer(lawyer);
        PersonEntity person = new PersonEntity();
        person.setEmail(lawyer.getPersonId().getEmail());
        MailDto mail = new MailDto();
        mail.setMail(lawyer.getPersonId().getEmail());
        //this.userBl.sendmail(mail);
        response.setCode("0000");
        response.setResponse("lawyer created");
        return response;
    }
    
    
    @PostMapping("/api/v1/sendmail")
    public ResponseDto<String> sendMail(@RequestBody MailDto mail) {
        ResponseDto<String> response = new ResponseDto<>();
        //this.userBl.saveVerification(mail);
        //this.userBl.sendmail(mail);
        response.setCode("0000");
        response.setResponse("mail sended");
        return response;
   
    }

    @PostMapping("/api/v1/verify")
    public ResponseDto<String> verifyMail(@RequestBody DeviceIdDto body) {
        ResponseDto<String> response = new ResponseDto<>();

        this.userBl.saveVerificationEntity(body);
        //this.userBl.sendmail(body.getEmail());
        response.setCode("0000");
        response.setResponse("verification mail sent");
        return response;
    }

    @PutMapping("/api/v1/verify")
    public ResponseDto<String> verifyMailCode(@RequestBody DeviceIdDto bodyFinal) {
        ResponseDto<String> response = new ResponseDto<>();
        if(this.userBl.verify(bodyFinal)){
            response.setCode("0000");
            response.setResponse("mail verified");
        }else{
            response.setCode("0001");
            response.setResponse("mail not verified");
        }
        return response;

    }

    //Get all Users
    @GetMapping("/api/v1/users")
    public ResponseDto<List<UserListDto>> getAllUsers(){
        ResponseDto<List<UserListDto>> response = new ResponseDto<>();
        if(this.userBl.getAllUsers().isEmpty()){
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("No users found");
        }else{
            response.setCode("0000");
            response.setResponse(this.userBl.getUsers());
            response.setErrorMessage(null);
        }

        return response;
    }






}
