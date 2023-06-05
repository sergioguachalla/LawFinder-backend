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
    private final EmailService emailService;
    private final VerificationRepository verificationRepository;
    private String verificationCode;

    PersonEntity personMemory = new PersonEntity();

    public UserBl(UserRepository userRepository, PersonRepository personRepository,  EmailService emailService,
                  VerificationRepository verificationRepository) {
        this.userRepository = userRepository;
        this.personRepository = personRepository;
        this.emailService = emailService;
        this.verificationRepository = verificationRepository;
    }

    @Transactional
    public void saveUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();

        // Convert PersonDto to PersonEntity
        PersonDto personDto = userDto.getPersonId();
        PersonEntity person = new PersonEntity();
        personMemory.setPersonId(Long.valueOf(1));
        // Convert AddressDto to AddressEntity

        person.setName(personDto.getName());
        person.setLastname(personDto.getLastname());
        person.setNumber(personDto.getNumber());
        person.setEmail(personDto.getEmail());
        person.setAddress(personDto.getAddress());
        person.setCi(personDto.getCi());
        person.setTx_user("lawfinder");
        person.setTx_date(new java.util.Date());
        person.setTx_host("localhost");
        personMemory = personRepository.save(person);

        // Generar código de verificación de 6 dígitos


        //String verificationCode = generateVerificationCode();



        // Enviar el código de verificación por correo electrónico
        String subject = "Código de verificación de LawFinder";
        String message = "Hola " + personMemory.getName() + " " + personMemory.getLastname() + ",\n\n"
                + "Gracias por registrarte en LawFinder. Tu código de verificación es: " + verificationCode + "\n\n"
                + "Utiliza este código para completar tu registro en LawFinder.\n\n"
                + "¡Bienvenido y que tengas una excelente experiencia con nuestra plataforma!";
        //emailService.sendEmail(personMemory.getEmail(), subject, message);

        // Set properties from userDto to userEntity
        userEntity.setUsername(userDto.getUsername());
        userEntity.setSecret(PasswordService.hashPassword(userDto.getSecret()));
        userEntity.setStatus(false);
        userEntity.setPersonId(person);
        //userEntity.setImageId(1);
        userEntity.setTxUser("lawfinder");
        userEntity.setTxHost("localhost");
        userEntity.setTxDate(new Date());
       // userEntity.setImageId(1);
        // Save userEntity in the database
        userRepository.save(userEntity);


    }

    public void sendmail(MailDto mail) {

        /*VerificationEntity verificationEntity = new VerificationEntity(
                personMemory,
                generateVerificationCode()
        );
        verificationRepository.saveAndFlush(verificationEntity);*/


        // Generar código de verificación de 6 dígitos
        verificationCode = generateVerificationCode();

        // Enviar el código de verificación por correo electrónico
        String subject = "Código de verificación de Law Finder";
        String message = "Hola " + ",\n\n"
                + "Gracias por registrarte en LawFinder. Tu código de verificación es: " + verificationCode + "\n\n"
                + "Utiliza este código para completar tu registro en LawFinder.\n\n"
                + "¡Bienvenido y que tengas una excelente experiencia con nuestra plataforma!";
        emailService.sendEmail(mail.getMail(), subject, message);     
    }

    public Boolean verify(DeviceIdDto deviceIdDto) {
        VerificationEntity verificationEntity = verificationRepository.findByDeviceId(deviceIdDto.getDeviceId());
        if (verificationEntity == null) {
            return false;
        }
        String codeHash = verificationEntity.getCodeHash();
        return deviceIdDto.getDeviceId().equals(codeHash);

    }

    public void initialVerification(DeviceIdDto deviceIdDto){
        VerificationEntity verificationEntity = verificationRepository.findByDeviceId(deviceIdDto.getDeviceId());


    }

    @Transactional
    public void saveVerificationEntity(DeviceIdDto deviceIdDto) {
        UUID uuid = UUID.randomUUID();
        VerificationEntity verificationEntity = new VerificationEntity();
        verificationEntity.setToken(uuid.toString());
        //TODO: cambiar la fecha para que sea en 5 minutos
        Date date = new Date();
        verificationEntity.setExpirationDate(date);
        verificationEntity.setCodeHash(generateVerificationCode());
        verificationEntity.setVcType(deviceIdDto.getType());
        verificationEntity.setDeviceId(deviceIdDto.getDeviceId());
        System.out.println(verificationEntity.toString());
        this.verificationRepository.save(verificationEntity);

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
