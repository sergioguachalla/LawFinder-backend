package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entitity.UserEntity;
import com.lawfinder.backend.dao.UserRepository;
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

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

}
