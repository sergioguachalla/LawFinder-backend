package com.lawfinder.backend.api;

import com.lawfinder.backend.bl.AuthBl;
import com.lawfinder.backend.dao.InstanceLegalCaseRepository;
import com.lawfinder.backend.dao.UserRepository;
import com.lawfinder.backend.dao.UserRoleRepository;
import com.lawfinder.backend.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
@CrossOrigin(origins = "*")
@RestController

class AuthApi {


    @Autowired
    AuthBl authBl;

    @PostMapping("/api/v1/auth/login")
    public ResponseDto<TokenDto> login(@RequestBody LoginDto login) {
        ResponseDto<TokenDto> response = new ResponseDto<>();

        TokenDto tokenDto = this.authBl.login(login);
        if (tokenDto == null) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid credentials");
            return response;
        } else {
            response.setCode("0000");
            response.setResponse(tokenDto);
            return response;
        }
    }
}