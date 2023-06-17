package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.ActorEntity;
import com.lawfinder.backend.Entity.CommentEntity;
import com.lawfinder.backend.Entity.LegalCaseEntity;
import com.lawfinder.backend.dao.ActorRepository;
import com.lawfinder.backend.dao.CommentRepository;
import com.lawfinder.backend.dao.LegalCaseRepository;
import com.lawfinder.backend.dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentBl {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ActorRepository actorRepository;

    private LegalCaseRepository legalCaseRepository;




    public CommentBl(CommentRepository commentRepository, ActorRepository actorRepository, LegalCaseRepository legalCaseRepository){
        this.commentRepository = commentRepository;
        this.actorRepository = actorRepository;
        this.legalCaseRepository = legalCaseRepository;

    }

    @Transactional
    public void saveComment(CommentDto commentDto){
        CommentEntity commentEntity = new CommentEntity();
        ActorEntity actorEntity = actorRepository.findByActorId(commentDto.getActorId());
        LegalCaseEntity legalCaseEntity = legalCaseRepository.findByLegalCaseId(commentDto.getLegalCaseId());
        commentEntity.setCommentContent(commentDto.getCommentContent());
        commentEntity.setActorId(actorEntity);
        commentEntity.setLegalCaseId(legalCaseEntity);
        commentRepository.save(commentEntity);


    }
    public List<CommentDto> getCommentsByLegalCaseId(Long legalCaseId){
        List<CommentEntity> commentEntities = commentRepository.findByLegalCaseId(legalCaseId);
        List<CommentDto> commentDtoList = new ArrayList<>();
        for(CommentEntity commentEntity : commentEntities){
            CommentDto commentDto = new CommentDto();
            commentDto.setCommentId(commentEntity.getCommentId());
            commentDto.setActorId(commentEntity.getActorId().getActorId());
            commentDto.setLegalCaseId(commentEntity.getLegalCaseId().getLegalCaseId());
            commentDto.setCommentContent(commentEntity.getCommentContent());
            commentDtoList.add(commentDto);
        }
        return commentDtoList;
    }





}
