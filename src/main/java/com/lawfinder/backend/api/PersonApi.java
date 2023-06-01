package com.lawfinder.backend.api;

import com.lawfinder.backend.bl.PersonBl;
import com.lawfinder.backend.dto.PersonDto;
import com.lawfinder.backend.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class PersonApi {

    @Autowired
    private PersonBl personBl;

    public PersonApi(PersonBl personBl){
        this.personBl = personBl;
    }

    @PostMapping("/api/v1/person")
    public ResponseDto<String> createPerson(@RequestBody PersonDto person) {
        ResponseDto<String> response = new ResponseDto<>();
        System.out.println(person.toString());
        this.personBl.addPerson(person);
        response.setCode("0000");
        response.setResponse("person created");
        return response;
    }

}
