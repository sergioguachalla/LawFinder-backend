package com.lawfinder.backend.bl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lawfinder.backend.config.exception.InvalidInputException;
import com.lawfinder.backend.dto.ActorOutDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawfinder.backend.Entity.ActorEntity;
import com.lawfinder.backend.dao.ActorRepository;
import com.lawfinder.backend.dto.ActorDto;
import com.lawfinder.backend.dto.InvitationDto;

@Service
public class ActorBl {
    @Autowired
    private final ActorRepository actorRepository;
    Logger logger = LoggerFactory.getLogger(ActorBl.class);

    public ActorBl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;

    }

    
    public List<InvitationDto> findByInvitationsId(Long personId) throws InvalidInputException {
        try{
            List<ActorEntity> actorEntity = actorRepository.findInvitationByUserId(personId);
            // transformar actorEntity a actorDto
            List<InvitationDto> ListinvitationDto = new ArrayList<>();

            actorEntity.forEach(actorEntity1 -> {
                ActorDto actorDto = new ActorDto();
                InvitationDto invitationDto = new InvitationDto();
                actorDto.setActorId(actorEntity1.getActorId());
                actorDto.setUserId((actorEntity1.getUserId().getId().intValue()));
                actorDto.setLegalCaseId(actorEntity1.getLegalCaseId().getLegalCaseId().intValue());

                String title = actorEntity1.getLegalCaseId().getTitle();
                Date startDate = actorEntity1.getLegalCaseId().getStartDate();

                invitationDto.setActorId(actorEntity1.getActorId());
                invitationDto.setUserId((actorEntity1.getUserId().getId().intValue()));
                invitationDto.setLegalCaseId(actorEntity1.getLegalCaseId().getLegalCaseId().intValue());
                invitationDto.setStatus(actorEntity1.getStatus());
                invitationDto.setTitle(title);
                invitationDto.setStartDate(startDate);

                ListinvitationDto.add(invitationDto);
            });
            return ListinvitationDto;

        } catch (Exception e){
            throw new InvalidInputException("Invalid input");
        }
    }

    public void acceptInvitation(Long actorId) {
        ActorEntity actorEntity = actorRepository.findById(actorId).orElse(null);
        assert actorEntity != null;
        actorEntity.setStatus(true);
        actorRepository.save(actorEntity);


    }

    public void declineInvitation(Long actorId) {
        ActorEntity actorEntity = actorRepository.findById(actorId).orElse(null);
        assert actorEntity != null;
        actorEntity.setStatus(false);
        actorRepository.save(actorEntity);
    }

    public List<ActorOutDto> getActorsByCaseId(String caseId) {
        Long caseIdLong = Long.parseLong(caseId);
        logger.info("caseIdLong: " + caseIdLong);
        List<ActorEntity> actorEntity = actorRepository.findAllByLegalCaseIdLegalCaseId(caseIdLong);

        List<ActorOutDto> listActorOutDto = new ArrayList<>();
        actorEntity.forEach(actorEntity1 -> {
            ActorOutDto actorOutDto = new ActorOutDto();
            actorOutDto.setActorId(actorEntity1.getActorId());
            actorOutDto.setUsername(actorEntity1.getUserId().getUsername());
            listActorOutDto.add(actorOutDto);
        });
        return listActorOutDto;

    }
}
