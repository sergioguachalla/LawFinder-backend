package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.RoleEntity;
import com.lawfinder.backend.Entity.UserEntity;
import com.lawfinder.backend.Entity.UserRoleEntity;
import com.lawfinder.backend.dao.RoleRepository;
import com.lawfinder.backend.dao.UserRepository;
import com.lawfinder.backend.dao.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service

public class RoleBl {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    private UserRoleRepository userRoleRepository;

    public RoleBl(UserRepository userRepository, RoleRepository roleRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
    }

    public void deleteUserRole(Long userId, Long roleId){
        UserRoleEntity userRoleEntity = userRoleRepository.findByUser_IdAndRole_Id(userId, roleId);
        userRoleEntity.setStatus(false);
        userRoleRepository.save(userRoleEntity);
    }

    //add new Role
    public void addUserRole(Long userId, Long roleId){
        //verificar si el user role ya lo tenia pero estaba en false
        UserRoleEntity userRoleEntity = userRoleRepository.findWithoutStatus(userId, roleId);
        if(userRoleEntity != null){
            userRoleEntity.setStatus(true);
            userRoleRepository.save(userRoleEntity);
            return;
        }
        UserRoleEntity userRoleEntity1 = new UserRoleEntity();
        UserEntity userEntity = userRepository.findByUserId(userId);
        RoleEntity roleEntity = roleRepository.findByRoleId(roleId);
        userRoleEntity1.setUser(userEntity);
        userRoleEntity1.setRole(roleEntity);
        userRoleEntity1.setStatus(true);
        userRoleEntity1.setTx_user("lawfinder");
        userRoleEntity1.setTx_host("localhost");
        userRoleEntity1.setTx_date(new Date());
        userRoleRepository.save(userRoleEntity1);
    }
}
