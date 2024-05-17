package com.lawfinder.backend.api;

import com.lawfinder.backend.Entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lawfinder.backend.bl.*;
import com.lawfinder.backend.dto.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")

@RestController
public class UserApi {
    @Autowired
    private UserBl userBl;
    // Constructor

    public UserApi(UserBl userBl) {
        this.userBl = userBl;
    }

    @PostMapping("/api/v1/user")
    public ResponseDto<String> createUser(@RequestBody UserDto user) {
        ResponseDto<String> response = new ResponseDto<>();
        this.userBl.saveCustomer(user);
        PersonEntity person = new PersonEntity();
        person.setEmail(user.getPersonId().getEmail());
        MailDto mail = new MailDto();
        mail.setMail(user.getPersonId().getEmail());
        //this.userBl.sendmail(mail);
        response.setCode("0000");
        response.setResponse("user created");
        return response;

        
    }

    @PostMapping("/api/v1/user/forgotpassword")
    public ResponseEntity<ResponseDto<String>> forgotPassword( @RequestBody MailDto mail ){
        ResponseDto<String> response = new ResponseDto<>();
        try{
            String email = mail.getMail();
            this.userBl.resetPassword(email);
            response.setCode("0000");
            response.setResponse("Se envio un correo con el link para restablecer la contraseña. Por favor revisa tu bandeja de entrada.");
            return ResponseEntity.ok(response);

        }catch (Exception e){
            response.setCode("0001");
            response.setResponse("No se encontró el usuario con el correo ingresado.");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/api/v1/user/resetpassword")
    public ResponseEntity<ResponseDto<String>> resetPassword(@RequestParam UUID passwordResetToken, @RequestBody ResetPasswordDto resetPasswordDto){
        ResponseDto<String> response = new ResponseDto<>();
        String newPassword = resetPasswordDto.getPassword();
        this.userBl.changePassword(passwordResetToken, newPassword);
        response.setCode("0000");
        response.setResponse("contraseña restablecida con éxito.");
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/api/v1/lawyer")
    public ResponseDto<String> createLawyer(@RequestBody UserDto lawyer){
        ResponseDto<String> response = new ResponseDto<>();
        this.userBl.saveLawyer(lawyer);
        PersonEntity person = new PersonEntity();
        person.setEmail(lawyer.getPersonId().getEmail());
        MailDto mail = new MailDto();
        mail.setMail(lawyer.getPersonId().getEmail());
        //this.userBl.sendmail(mail);
        response.setCode("0000");
        response.setResponse("lawyer created");
        return response;
    }
    
    
    @PostMapping("/api/v1/sendmail")
    public ResponseDto<String> sendMail(@RequestBody MailDto mail) {
        ResponseDto<String> response = new ResponseDto<>();
        //this.userBl.saveVerification(mail);
        //this.userBl.sendmail(mail);
        response.setCode("0000");
        response.setResponse("mail sended");
        return response;
   
    }

    @PostMapping("/api/v1/verify")
    public ResponseDto<String> verifyMail(@RequestBody DeviceIdDto body) {
        ResponseDto<String> response = new ResponseDto<>();

        this.userBl.saveVerificationEntity(body);
        //this.userBl.sendmail(body.getEmail());
        response.setCode("0000");
        response.setResponse("verification mail sent");
        return response;
    }

    @PutMapping("/api/v1/verify")
    public ResponseDto<String> verifyMailCode(@RequestBody DeviceIdDto bodyFinal) {
        ResponseDto<String> response = new ResponseDto<>();
        if(this.userBl.verify(bodyFinal)){
            response.setCode("0000");
            response.setResponse("mail verified");
        }else{
            response.setCode("0001");
            response.setResponse("mail not verified");
        }
        return response;

    }

    //Get all Users
    @GetMapping("/api/v1/users")
    public ResponseDto<List<UserListDto>> getAllUsers(){
        ResponseDto<List<UserListDto>> response = new ResponseDto<>();
        if(this.userBl.getAllUsers().isEmpty()){
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("No users found");
        }else{
            response.setCode("0000");
            response.setResponse(this.userBl.getUsers());
            response.setErrorMessage(null);
        }

        return response;
    }

    //delete user
    @PutMapping("/api/v1/users/{id}")
    public ResponseDto<String> deleteUser(@PathVariable Long id){
        ResponseDto<String> response = new ResponseDto<>();
        try{
            this.userBl.deleteUser(id);
            response.setCode("0000");
            response.setResponse("User deleted");
            response.setErrorMessage(null);

        }catch (Exception e){
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("User not found");
        }
        return response;
    }

    @GetMapping("/api/v1/users/{id}/role/edit")
    public ResponseDto<EditUserDto> getUserEditRoles(@PathVariable Long id){
        ResponseDto<EditUserDto> response = new ResponseDto<>();
        try{
            response.setCode("0000");
            response.setResponse(this.userBl.getUserEditRoles(id));
            response.setErrorMessage(null);
        }catch (Exception e){
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("User not found");
        }
        return response;
    }

    //update user
    @PutMapping("/api/v1/users/{id}/update")
    public ResponseDto<String> updateUser(@PathVariable Long id, @RequestBody UserDto user){
        ResponseDto<String> response = new ResponseDto<>();
        try{
            this.userBl.updateUser(id, user);
            response.setCode("0000");
            response.setResponse("User updated");
            response.setErrorMessage(null);
        }catch (Exception e){
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("User not found");
        }
        return response;
    }









}
