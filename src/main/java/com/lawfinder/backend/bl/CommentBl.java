package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.ActorEntity;
import com.lawfinder.backend.Entity.CommentEntity;
import com.lawfinder.backend.Entity.LegalCaseEntity;
import com.lawfinder.backend.Entity.UserEntity;
import com.lawfinder.backend.dao.ActorRepository;
import com.lawfinder.backend.dao.CommentRepository;
import com.lawfinder.backend.dao.LegalCaseRepository;
import com.lawfinder.backend.dao.UserRepository;
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
    private UserRepository userRepository;

    private LegalCaseRepository legalCaseRepository;




    public CommentBl(CommentRepository commentRepository, UserRepository userRepository, LegalCaseRepository legalCaseRepository){
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.legalCaseRepository = legalCaseRepository;

    }

    @Transactional
    public void saveComment(CommentDto commentDto){
        CommentEntity commentEntity = new CommentEntity();
        UserEntity userEntity = userRepository.findByUserId(commentDto.getUserId());
        LegalCaseEntity legalCaseEntity = legalCaseRepository.findByLegalCaseId(commentDto.getLegalCaseId());
        commentEntity.setCommentContent(commentDto.getCommentContent());
        commentEntity.setUserId(userEntity);
        commentEntity.setLegalCaseId(legalCaseEntity);
        commentRepository.save(commentEntity);


    }
    public List<CommentDto> getCommentsByLegalCaseId(Long legalCaseId){
        List<CommentEntity> commentEntities = commentRepository.findByLegalCaseId(legalCaseId);
        List<CommentDto> commentDtoList = new ArrayList<>();
        for(CommentEntity commentEntity : commentEntities){
            CommentDto commentDto = new CommentDto();
            commentDto.setCommentId(commentEntity.getCommentId());
            commentDto.setUserId(commentEntity.getUserId().getId());
            commentDto.setLegalCaseId(commentEntity.getLegalCaseId().getLegalCaseId());
            commentDto.setCommentContent(commentEntity.getCommentContent());
            commentDto.setUserName(commentEntity.getUserId().getUsername());
            commentDtoList.add(commentDto);
        }
        return commentDtoList;
    }





}
