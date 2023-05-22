package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.*;
import com.lawfinder.backend.dao.*;
import com.lawfinder.backend.dto.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonBl {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private final AddressRepository addressRepository;

    public PersonBl(PersonRepository personRepository, AddressRepository addressRepository){
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    public void addPerson(PersonDto person){
        PersonEntity personEntity = new PersonEntity();

        // Convert AddressDto to AddressEntity
        AddressDto addressDto = person.getAddress();
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressInfo(addressDto.getAddressInfo());
        addressEntity.setProvId(addressDto.getProvId());

         // save the address before setting it to the person entity
         addressEntity = addressRepository.save(addressEntity);

                // Set properties from personDto to personEntity
        personEntity.setName(person.getName());
        personEntity.setLastname(person.getLastname());
        personEntity.setNumber(person.getNumber());
        personEntity.setEmail(person.getEmail());
        personEntity.setAddress(addressEntity);

        // Save personEntity in the database
        personEntity = personRepository.save(personEntity);

        // Set the personId from the database to the personDto  
        this.personRepository.saveAndFlush(personEntity);
       
    }

    public PersonEntity savePerson(PersonEntity personEntity){
        return personRepository.save(personEntity);
    }

}

