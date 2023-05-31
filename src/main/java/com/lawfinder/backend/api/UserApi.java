package com.lawfinder.backend.api;

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
    /* 

    @GetMapping("/api/v1/user")
    public ResponseDto<List<UserDto>> getAllTasks(
        @RequestHeader("Authorization") String token) {
         AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            ResponseDto<List<UserDto>> response = new ResponseDto<>();
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            return response;
        }
        ResponseDto<List<UserDto>> response = new ResponseDto<>();
        response.setCode("0000");

        response.setResponse(this.userBl.getAllUsers());

        return response;
    }
    */

    @PostMapping("/api/v1/user")
    public ResponseDto<String> createUser(@RequestBody UserDto user /* , @RequestHeader("Authorization") String token*/) {
        ResponseDto<String> response = new ResponseDto<>();
       /*  AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            return response;
        }
        
        */
        System.out.println(user.toString());
        this.userBl.saveUser(user);;
        response.setCode("0000");
        response.setResponse("user created");
        return response;

        
    }



}
