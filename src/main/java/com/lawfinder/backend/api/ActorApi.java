
package com.lawfinder.backend.api;
import java.util.*;

import com.lawfinder.backend.bl.AuthBl;
import org.springframework.beans.factory.annotation.Autowired;
import com.lawfinder.backend.bl.ActorBl;
import com.lawfinder.backend.dto.*;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*")

@RestController
public class ActorApi {
    @Autowired
    private ActorBl actorBl;

    @GetMapping("/api/v1/invitation/{idUser}")
    public ResponseDto<List<ActorDto>> getInvitationsById(/*@RequestHeader("Authorization") String token,*/ @PathVariable Long idUser){
        /*
        AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            ResponseDto<DepartmentDto> response = new ResponseDto<>();
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            return response;
        }
        */

        ResponseDto<List<ActorDto>> response = new ResponseDto<>();
        response.setCode("0000");
        response.setResponse(this.actorBl.findByInvitationsId(idUser));
        response.setErrorMessage(null);
        return response;

    }

    @PutMapping("/api/v1/actor/{idCase}")
    public ResponseDto<String> acceptInvitation(@PathVariable Long idCase){
        ResponseDto<String> response = new ResponseDto<>();
        this.actorBl.acceptInvitation(idCase);
        response.setCode("0000");
        response.setResponse("Invitacion aceptada");
        response.setErrorMessage(null);
        return response;

    }




    
}
