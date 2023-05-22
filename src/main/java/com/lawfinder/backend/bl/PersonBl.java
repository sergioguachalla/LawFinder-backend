package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.PersonEntity;
import com.lawfinder.backend.dao.PersonRepository;
import com.lawfinder.backend.dto.PersonDto;
import java.util.*;

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
        personEntity.setName(person.getName());
        personEntity.setLastname(person.getLastname());
        personEntity.setNumber(person.getNumber());
        personEntity.setEmail(person.getEmail());
        personEntity.setAddress(1);
        this.personRepository.save(personEntity);
    }

    public PersonEntity savePerson(PersonEntity personEntity){
        return personRepository.save(personEntity);
    }

}
