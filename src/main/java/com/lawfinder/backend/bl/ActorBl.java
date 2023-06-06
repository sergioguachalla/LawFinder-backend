package com.lawfinder.backend.bl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawfinder.backend.Entity.ActorEntity;
import com.lawfinder.backend.dao.ActorRepository;
import com.lawfinder.backend.dto.ActorDto;

@Service
public class ActorBl {
    @Autowired
    private final ActorRepository actorRepository;

    public ActorBl( ActorRepository actorRepository){
        this.actorRepository= actorRepository;

    }

    public List<ActorDto> findByInvitationsId(Long personId){
        List<ActorEntity> actorEntity = actorRepository.findInvitationByUserId(personId);
        // transformar actorEntity a actorDto
        List<ActorDto> ListactorDto = new ArrayList<>();

        actorEntity.forEach(actorEntity1 -> {
            ActorDto actorDto = new ActorDto();
            actorDto.setActorId(actorEntity1.getActorId());
            actorDto.setUserId((actorEntity1.getUserId().getId().intValue()));
            actorDto.setLegalCaseId(actorEntity1.getLegalCaseId().getLegalCaseId().intValue());
            ListactorDto.add(actorDto);
        });
        return ListactorDto;

    }

    public void acceptInvitation(Long actorId){
        ActorEntity actorEntity= actorRepository.findById(actorId).orElse(null);
        actorEntity.setStatus(true);
        actorRepository.save(actorEntity);
    }


}
