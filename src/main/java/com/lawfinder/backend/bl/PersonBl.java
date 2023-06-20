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


    public PersonBl(PersonRepository personRepository){
        this.personRepository = personRepository;

    }

    public void addPerson(PersonDto person){
        PersonEntity personEntity = new PersonEntity();

        // Convert AddressDto to AddressEntity
        /*AddressDto addressDto = person.getAddress();
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressInfo(addressDto.getAddressInfo());
        addressEntity.setProvId(addressDto.getProvId());

        // save the address before setting it to the person entity
        addressEntity = addressRepository.save(addressEntity);*/

        // Set properties from personDto to personEntity
        personEntity.setName(person.getName());
        personEntity.setLastname(person.getLastname());
        personEntity.setNumber(person.getNumber());
        personEntity.setEmail(person.getEmail());
        personEntity.setCi(person.getCi());
        personEntity.setAddress(person.getAddress());
        personEntity.setTx_user("admin");
        personEntity.setTx_date(new java.util.Date());
        personEntity.setTx_host("localhost");
        System.out.println(personEntity);

        // Save personEntity in the database
        personEntity = personRepository.save(personEntity);

        // Set the personId from the database to the personDto  
        this.personRepository.saveAndFlush(personEntity);
       
    }

    public PersonEntity savePerson(PersonEntity personEntity){
        return personRepository.save(personEntity);
    }

    public boolean getPersonByFullName(String name, String lastname){

        PersonEntity personEntity = personRepository.findByName(name, lastname);

        return personEntity != null;

    }
}

