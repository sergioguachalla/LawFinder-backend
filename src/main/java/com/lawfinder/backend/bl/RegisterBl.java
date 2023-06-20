package com.lawfinder.backend.bl;

import com.lawfinder.backend.dao.PersonRepository;
import com.lawfinder.backend.dao.UserRepository;
import com.lawfinder.backend.dto.PersonDto;
import com.lawfinder.backend.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterBl {


    @Autowired
    private final UserBl userBl;
    @Autowired
    private final PersonBl personBl;

    public RegisterBl(PersonBl personBl, UserBl userBl) {
        this.personBl = personBl;
        this.userBl = userBl;
    }



}
