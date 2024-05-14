package com.lawfinder.backend.api;

import com.lawfinder.backend.bl.AuthBl;
import com.lawfinder.backend.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
            if (authBl.isAccountBlocked(login.getUsername())) {
                response.setCode("0002");
                response.setResponse(null);
                response.setErrorMessage("Account blocked");
            } else {
                response.setCode("0001");
                response.setResponse(null);
                response.setErrorMessage("Invalid credentials");
            }
            return response;
        } else {
            response.setCode("0000");
            response.setResponse(tokenDto);
            return response;
        }
    }

    @PutMapping("/api/v1/user/{id}/unlock")
    public ResponseDto<String> unlockUser(@PathVariable Long id) {
        ResponseDto<String> response = new ResponseDto<>();
        if (authBl.unlockUser(id)) {
            response.setCode("0000");
            response.setResponse("User unlocked");
            response.setErrorMessage(null);
        } else {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
        }
        return response;
    }
}