package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.*;
import com.lawfinder.backend.dao.*;
import com.lawfinder.backend.dto.*;
import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserBl {
    private final UserRepository userRepository;
    private final PersonRepository personRepository;
    private final AddressRepository addressRepository;

    public UserBl(UserRepository userRepository, PersonRepository personRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    @Transactional
    public void saveUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        System.out.println("00000000000000000000000000000000000000000000000000000000000000000000000000000000000");
        System.out.println(userDto.toString());
        System.out.println("00000000000000000000000000000000000000000000000000000000000000000000000000000000000");

        System.out.println(userDto.getPersonId().toString());
        System.out.println("00000000000000000000000000000000000000000000000000000000000000000000000000000000000");


        // Convert PersonDto to PersonEntity
        PersonDto personDto = userDto.getPersonId();
        PersonEntity person = new PersonEntity();
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressInfo(personDto.getAddress().getAddressInfo());
        addressEntity.setProvId(personDto.getAddress().getProvId());
        addressEntity = addressRepository.save(addressEntity);
        person.setName(personDto.getName());
        person.setLastname(personDto.getLastname());
        person.setNumber(personDto.getNumber());
        person.setEmail(personDto.getEmail());
        person.setAddress(addressEntity);
        personRepository.saveAndFlush(person);
/* 
        PersonEntity personEntity = personRepository.findById(personDto.getPersonId())
                .orElseThrow(() -> new RuntimeException("Person not found"));

        // Set properties from userDto to userEntity

        personRepository.saveAndFlush(personEntity);
        */

        userEntity.setUsername(userDto.getUsername());
        userEntity.setUserLastname(userDto.getUserLastname());
        userEntity.setSecret(userDto.getSecret()); // this should be hashed!
        userEntity.setStatus(true);
        userEntity.setPersonId(person);
        userEntity.setImageId(1);
        userEntity.setTxUser("lawfinder");
        userEntity.setTxHost("localhost");
        userEntity.setTxDate(new Date());


        // Save userEntity in the database
        userRepository.save(userEntity);

    }
    /* 

    public List<UserDto> findAll(){
        List<UserEntity> user = userRepository.findAll();
        List<UserDto> users = new ArrayList<>();
        
        user.forEach(user1 -> {
            users.add(new UserDto(user1.getId(),  user1.getUsername(), user1.getUserLastname(),  
            user1.getSecret(), user1.getStatus(), user1.getPersonId(),user1.getImageId(),"","",new Date()
            ));
        });
        return users;

        
    }
    */



}
