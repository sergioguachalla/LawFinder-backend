package com.lawfinder.backend.api;

import com.lawfinder.backend.bl.AuthBl;
import com.lawfinder.backend.bl.TokenBl;
import com.lawfinder.backend.dto.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController

class AuthApi {


    @Autowired
    AuthBl authBl;
    @Autowired private TokenBl tokenBl;

    private Logger logger = org.slf4j.LoggerFactory.getLogger(AuthApi.class);

    @PostMapping("/api/v1/auth/login")
    public ResponseDto<TokenDto> login(@RequestBody LoginDto login) {
        ResponseDto<TokenDto> response = new ResponseDto<>();

        TokenDto tokenDto = this.authBl.login(login);
        logger.info("TokenDto: {}", tokenDto);
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
    public ResponseDto<String> unlockUser(
            @PathVariable Long id,
            @RequestHeader("Authorization") String token,
            HttpServletRequest request
            ) {
        ResponseDto<String> response = new ResponseDto<>();
        String ipAddress = authBl.getClientIp(request);


        if (authBl.unlockUser(id, tokenBl.getUsernameFromToken(token),ipAddress)) {
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