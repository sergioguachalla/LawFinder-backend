package com.lawfinder.backend.api;

import com.lawfinder.backend.bl.PersonBl;
import com.lawfinder.backend.bl.UserBl;
import com.lawfinder.backend.dto.DeviceIdDto;
import com.lawfinder.backend.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class RegistrationApi {

    @Autowired
    private UserBl registrationBl;

    @Autowired
    private PersonBl personBl;


    @PostMapping("/api/v1/verification")
    public ResponseDto<String> getVerification(@RequestBody DeviceIdDto deviceIdDto){
        ResponseDto<String> response = new ResponseDto<>();
        if(this.registrationBl.verifyUserByEmail(deviceIdDto)){
            response.setCode("0001");
            response.setResponse("User Already Exists");
            response.setErrorMessage(null);
        }
        else{
            response.setCode("0000");
            response.setResponse("User Does Not Exist");
            response.setErrorMessage(null);
        }

        return response;

    }

    @GetMapping("/api/v1/verification/user/{name}/{lastname}")
    public ResponseDto<String> getVerification(@PathVariable String name, @PathVariable String lastname){
        ResponseDto<String> response = new ResponseDto<>();
        if(personBl.getPersonByFullName(name, lastname)){
            response.setCode("0001");
            response.setResponse("User Already Exists");
            response.setErrorMessage(null);
        }
        else{
            response.setCode("0000");
            response.setResponse("User Does Not Exist");
            response.setErrorMessage(null);
        }

        return response;

    }

}
