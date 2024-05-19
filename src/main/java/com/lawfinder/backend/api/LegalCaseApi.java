package com.lawfinder.backend.api;

import com.lawfinder.backend.bl.*;
import com.lawfinder.backend.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

@CrossOrigin(origins = "*")
@RestController
public class LegalCaseApi {
    @Autowired
    private LegalCaseBl legalCaseBl;
    
    @Autowired
    private CategoryBl categoryBl;

    @Autowired
    private UserBl registrationBl;

    @Autowired
    private CommentBl commentBl;
    @Autowired
    private AuthBl authBl;

    private Stack<String> pendingInvitations = new Stack<>();
    Set<Integer> conjunto = new HashSet<>();


    @PostMapping("/api/v1/userverification")
    public ResponseDto<String> getVerification(@RequestBody DeviceIdDto deviceIdDto){
        ResponseDto<String> response = new ResponseDto<>();
        if(this.registrationBl.verifyUserByEmail(deviceIdDto)){
            pendingInvitations.push(deviceIdDto.getEmail());
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
    
    @PostMapping("/api/v1/legalcase")
    public ResponseDto<String> createCase(@RequestBody LegalCaseDto legalCase , @RequestHeader("Authorization") String token) {
        ResponseDto<String> response = new ResponseDto<>();

        if (!authBl.validateToken(token)) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            return response;
        }

        this.legalCaseBl.saveLegalCase(legalCase,pendingInvitations);
        response.setCode("0000");
        response.setResponse("Task created");
        pendingInvitations.clear();

        return response;

        
    }

    @GetMapping("/api/v1/category/{id}/subcategory")
    public ResponseDto<List<SubCategoryDto>> getSubcategories(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        ResponseDto<List<SubCategoryDto>> response = new ResponseDto<>();
        if (!authBl.validateToken(token)) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            return response;
        }
        response.setCode("0000");
        response.setResponse(this.categoryBl.findAllSubCategoriesByCategoryId(id));
        response.setErrorMessage(null);
        return response;

    }

    @GetMapping("/api/v1/legalcase/instance")
    public ResponseDto<List<InstanceDto>> getInstances( /* , @RequestHeader("Authorization") String token*/) {
        ResponseDto<List<InstanceDto>> response = new ResponseDto<>();
       /*  AuthBl authBl = new AuthBl();
        if (!authBl.validateToken(token)) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            return response;
        }
        */
        //this.categoryBl.findAllSubCategoriesByCategoryId(id);
        response.setCode("0000");
        response.setResponse(this.legalCaseBl.findAllInstances());
        response.setErrorMessage(null);
        return response;

    }


    @GetMapping("/api/v1/legalcase/user/{id}")
    public ResponseDto<Page<LegalCaseDto>> getLegalCasesByUserId(
            @PathVariable Long id,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date to,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) Long instanceId,
            @RequestParam(required = false) Boolean inProgress,
            @RequestParam(required = false) String title,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){

        ResponseDto<Page<LegalCaseDto>> response = new ResponseDto<>();
        Pageable pageable = PageRequest.of(page, size);
        Page<LegalCaseDto> legalCasesPage = legalCaseBl.findAllByUserIdWithFilters(id, from, to, categoryId, instanceId, inProgress,title ,pageable);
        response.setCode("0000");
        response.setResponse(legalCasesPage);
        response.setErrorMessage(null);
        return response;
    }

    @PutMapping("/api/v1/legalcase/{id}")
    public ResponseDto<String> updateLegalCase(@PathVariable Long id, @RequestHeader("Authorization") String token) {
        ResponseDto<String> response = new ResponseDto<>();
        if (!authBl.validateToken(token)) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            return response;
        }

        this.legalCaseBl.updateLegalCase(id);
        response.setCode("0000");
        response.setResponse("Case updated");
        response.setErrorMessage(null);
        return response;
    }


    @GetMapping("api/v1/legalcase/{id}/information")
    public ResponseDto<CaseInformationDto> getCaseInformation(@PathVariable Long id){
        ResponseDto<CaseInformationDto> response = new ResponseDto<>();
        response.setCode("0000");
        response.setResponse(this.legalCaseBl.getCaseInformationByCaseId(id));
        response.setErrorMessage(null);
        return response;
    }

    @PostMapping("/api/v1/legalcase/{id}/comment")
    public ResponseDto<String> createComment(@PathVariable Long id, @RequestBody CommentDto commentDto){
        ResponseDto<String> response = new ResponseDto<>();
        this.commentBl.saveComment(commentDto);
        response.setCode("0000");
        response.setResponse("Comment created");
        response.setErrorMessage(null);
        return response;
    }


    @GetMapping("/api/v1/legalcase/{id}/comments")
    public ResponseDto<Page<CommentDto>> getComments(@PathVariable Long id, @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){

        ResponseDto<Page<CommentDto>> response = new ResponseDto<>();
        Pageable pageable = PageRequest.of(page, size);
        Page<CommentDto> commentsPage = this.commentBl.getCommentsByLegalCaseId(id, pageable);
        response.setCode("0000");
        response.setResponse(commentsPage);
        response.setErrorMessage(null);
        return response;
    }

    @PostMapping("/api/v1/legalcase/{id}/instance")
    public ResponseDto<String> createInstance(@PathVariable Long id, @RequestBody InstanceLegalCaseDto instanceLegalCaseDto){
        ResponseDto<String> response = new ResponseDto<>();
        this.legalCaseBl.updateInstanceLegalCase(id, instanceLegalCaseDto);
        response.setCode("0000");
        response.setResponse("Instance created");
        response.setErrorMessage(null);
        return response;
    }

    @PostMapping("/api/v1/legalcase/{id}/invitation")
    public ResponseDto<String> createInvitation(@PathVariable Long id, @RequestBody NewInvitationDto newInvitationDto){
        ResponseDto<String> response = new ResponseDto<>();
        System.out.println(newInvitationDto.getEmail());
        if(this.legalCaseBl.sendInvitation(id, newInvitationDto.getEmail())){
            response.setCode("0001");
            response.setResponse("Invitation sended");
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





