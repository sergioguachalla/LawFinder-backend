package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.*;
import com.lawfinder.backend.dao.*;
import com.lawfinder.backend.dto.*;
import java.util.*;

import com.lawfinder.backend.services.EmailService;
import com.lawfinder.backend.services.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserBl {
    private final UserRepository userRepository;
    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;
    private final EmailService emailService;
    private String verificationCode;

    public UserBl(UserRepository userRepository, PersonRepository personRepository, AddressRepository addressRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
        this.emailService = emailService;
    }

    @Transactional
    public void saveUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();

        // Convert PersonDto to PersonEntity
        PersonDto personDto = userDto.getPersonId();
        PersonEntity person = new PersonEntity();

        // Convert AddressDto to AddressEntity
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressInfo(personDto.getAddress().getAddressInfo());
        addressEntity.setProvId(personDto.getAddress().getProvId());

        // save the address before setting it to the person entity
        addressEntity = addressRepository.save(addressEntity);

        person.setName(personDto.getName());
        person.setLastname(personDto.getLastname());
        person.setNumber(personDto.getNumber());
        person.setEmail(personDto.getEmail());
        person.setAddress(addressEntity);
        PersonEntity personMemory = personRepository.save(person);

        // Generar código de verificación de 6 dígitos
        String verificationCode = generateVerificationCode();

        // Enviar el código de verificación por correo electrónico
        String subject = "Código de verificación de LawFinder";
        String message = "Hola " + personMemory.getName() + " " + personMemory.getLastname() + ",\n\n"
                + "Gracias por registrarte en LawFinder. Tu código de verificación es: " + verificationCode + "\n\n"
                + "Utiliza este código para completar tu registro en LawFinder.\n\n"
                + "¡Bienvenido y que tengas una excelente experiencia con nuestra plataforma!";
        emailService.sendEmail(personMemory.getEmail(), subject, message);

        // Set properties from userDto to userEntity
        userEntity.setUsername(userDto.getUsername());
        userEntity.setSecret(PasswordService.hashPassword(userDto.getSecret()));
        userEntity.setStatus(true);
        userEntity.setPersonId(person);
        userEntity.setImageId(1);
        userEntity.setTxUser("lawfinder");
        userEntity.setTxHost("localhost");
        userEntity.setTxDate(new Date());

        // Save userEntity in the database
        userRepository.save(userEntity);
    }

    public void sendmail(MailDto mail) {
        // Generar código de verificación de 6 dígitos
        verificationCode = generateVerificationCode();

        // Enviar el código de verificación por correo electrónico
        String subject = "Código de verificación de LawFinder";
        String message = "Hola " + ",\n\n"
                + "Gracias por registrarte en LawFinder. Tu código de verificación es: " + verificationCode + "\n\n"
                + "Utiliza este código para completar tu registro en LawFinder.\n\n"
                + "¡Bienvenido y que tengas una excelente experiencia con nuestra plataforma!";
        emailService.sendEmail(mail.getMail(), subject, message);     
    }

    public Boolean verify(VerifyDto mail){
        String code= mail.getToken();
        if(code.equals(verificationCode)){
            return true;
        }else{
            return false;
        }
        
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    // Generar código de verificación de 6 dígitos
    private String generateVerificationCode() {
        Random random = new Random();
        int code = random.nextInt(900000) + 100000; // Generar número aleatorio de 6 dígitos
        return String.valueOf(code);
    }
}
