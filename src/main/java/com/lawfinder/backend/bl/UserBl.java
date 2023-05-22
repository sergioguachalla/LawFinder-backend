package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.UserEntity;
import com.lawfinder.backend.dao.UserRepository;
import com.lawfinder.backend.dto.UserDto;
import java.util.*;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBl {
    private final UserRepository userRepository;

    public UserBl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public UserEntity saveUser(UserEntity userEntity){
        return userRepository.save(userEntity);
    }

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

}
