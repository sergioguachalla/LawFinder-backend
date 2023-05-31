package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.*;
import com.lawfinder.backend.dao.*;
import com.lawfinder.backend.dto.*;
import java.util.*;

import com.lawfinder.backend.services.EmailService;
import com.lawfinder.backend.services.PasswordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserBl {
    private final UserRepository userRepository;
    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;
    private final EmailService emailService;


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

        /*
            This is where the verification email is sent to the user

         */
        emailService.sendEmail(personMemory.getEmail(), "Bienvenido a LawFinder", "Hola " + personMemory.getName() + " " + personMemory.getLastname() + " gracias por registrarte en LawFinder");

        //personRepository.saveAndFlush(person);

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

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
}
