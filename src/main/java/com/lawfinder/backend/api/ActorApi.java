
package com.lawfinder.backend.api;
import java.util.*;

import com.lawfinder.backend.bl.AuthBl;
import com.lawfinder.backend.config.exception.InvalidInputException;

import com.lawfinder.backend.bl.TokenBl;

import org.springframework.beans.factory.annotation.Autowired;
import com.lawfinder.backend.bl.ActorBl;
import com.lawfinder.backend.dto.*;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*")

@RestController
public class ActorApi {
    @Autowired
    private ActorBl actorBl;

    @Autowired private AuthBl authBl;
    @Autowired private TokenBl tokenBl;

    @GetMapping("/api/v1/invitation/{idUser}")
    public ResponseDto<List<InvitationDto>> getInvitationsById
            (@RequestHeader("Authorization") String token, @PathVariable Long idUser) throws InvalidInputException {
        /**
         * Validar el id del usuario
         */
        if(idUser == null){
            throw new InvalidInputException("El id del usuario no puede ser nulo");
        }
        if(idUser <= 0){
            throw new InvalidInputException("El id del usuario no puede ser menor o igual a 0");
        }
        /**
         * Validar el token de acceso
         */
        if (!authBl.validateToken(token)) {
            ResponseDto<List<InvitationDto>> response = new ResponseDto<>();
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid tokenXD");
            return response;
        }

            ResponseDto<List<InvitationDto>> response = new ResponseDto<>();
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

    @DeleteMapping("/api/v1/actor/{idCase}")
    public ResponseDto<String> declineInvitation(@PathVariable Long idCase){
        ResponseDto<String> response = new ResponseDto<>();
        this.actorBl.declineInvitation(idCase);
        response.setCode("0000");
        response.setResponse("Invitacion rechazada");
        response.setErrorMessage(null);
        return response;
    }

    @GetMapping("/api/v1/cases/{caseId}/actors")
    public ResponseDto<List<ActorOutDto>> getActorsByCaseId(@PathVariable String caseId){
        ResponseDto<List<ActorOutDto>> response = new ResponseDto<>();
        response.setCode("0000");
        response.setResponse(this.actorBl.getActorsByCaseId(caseId));
        response.setErrorMessage(null);
        return response;
    }







    
}
