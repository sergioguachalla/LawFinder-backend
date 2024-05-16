package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.PrivilegeEntity;
import com.lawfinder.backend.Entity.PrivilegeRoleEntity;
import com.lawfinder.backend.Entity.RoleEntity;
import com.lawfinder.backend.dao.PrivilegeRepository;
import com.lawfinder.backend.dao.PrivilegeRoleRepository;
import com.lawfinder.backend.dao.RoleRepository;
import com.lawfinder.backend.dto.RoleDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    @Autowired private RoleRepository roleRepository;
    @Autowired private PrivilegeRoleRepository privilegeRoleRepository;
    @Autowired private PrivilegeRepository privilegeRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private UserRoleRepository userRoleRepository;
    /**
    Sergio
    **/
    private final Logger logger = LoggerFactory.getLogger(RoleBl.class);

    public void saveRole(RoleDto roleDto){
        RoleEntity roleEntity = new RoleEntity();
        logger.info("RoleDto: {}", roleDto.getRoleName());
        logger.info("RoleDto: {}", roleDto.getRoleId());
        logger.info("RoleDto: {}", roleDto.toString());
        roleEntity.setRoleName(roleDto.getRoleName());
        roleEntity.setStatus(1);
        roleRepository.save(roleEntity);
    }

    public void addPrivilegeToRole(Long roleId, List<Long> privileges) {
        RoleEntity roleEntity = roleRepository.findById(roleId).orElseThrow();

        for (Long privilegeId : privileges) {
            PrivilegeEntity privilegeEntity = privilegeRepository.findById(privilegeId).orElseThrow();
            PrivilegeRoleEntity privilegeRoleEntity = new PrivilegeRoleEntity();
            privilegeRoleEntity.setRole(roleEntity);
            privilegeRoleEntity.setPrivilege(privilegeEntity);
            privilegeRoleEntity.setStatus(1);
            privilegeRoleRepository.save(privilegeRoleEntity);
        }

    }

    public List<RoleDto> findRoles() {
        List<RoleEntity> roleEntities = roleRepository.findAll();
        return roleEntities.stream().map(roleEntity -> {
            List<String> privileges = new ArrayList<>();

            RoleDto roleDto = new RoleDto();
            roleDto.setRoleId(roleEntity.getRoleId());
            roleDto.setRoleName(roleEntity.getRoleName());
            logger.info("Role ID: {}", roleEntity.getRoleId());
            List<PrivilegeRoleEntity> privilegeRoleEntities = privilegeRoleRepository.
                    findAllByRoleRoleId(roleEntity.getRoleId());
               privilegeRoleEntities.forEach(privilegeRoleEntity -> {
                   logger.info("Privilege: {}", privilegeRoleEntity.getPrivilege().getPriv());
                   privileges.add(privilegeRoleEntity.getPrivilege().getPriv());
                       }
                );
            roleDto.setPrivileges(privileges);
            return roleDto;
        }).toList();
    }
  
  /**
  Ale
  **/

 public void deleteUserRole(Long userId, Long roleId){
        UserRoleEntity userRoleEntity = userRoleRepository.findByUser_IdAndRole_Id(userId, roleId);
        userRoleEntity.setStatus(0);
        userRoleRepository.save(userRoleEntity);
    }

    //add new Role
    public void addUserRole(Long userId, Long roleId){
        //verificar si el user role ya lo tenia pero estaba en false
        UserRoleEntity userRoleEntity = userRoleRepository.findWithoutStatus(userId, roleId);
        if(userRoleEntity != null){
            userRoleEntity.setStatus(1);
            userRoleRepository.save(userRoleEntity);
            return;
        }
        UserRoleEntity userRoleEntity1 = new UserRoleEntity();
        UserEntity userEntity = userRepository.findByUserId(userId);
        RoleEntity roleEntity = roleRepository.findByRoleId(roleId);
        userRoleEntity1.setUser(userEntity);
        userRoleEntity1.setRole(roleEntity);
        userRoleEntity1.setStatus(1);
        userRoleEntity1.setTx_user("lawfinder");
        userRoleEntity1.setTx_host("localhost");
        userRoleEntity1.setTx_date(new Date());
        userRoleRepository.save(userRoleEntity1);
    }

    public RoleDto findRoleById(Long id) {
        RoleEntity roleEntity = roleRepository.findById(id).orElseThrow();
        RoleDto roleDto = new RoleDto();
        roleDto.setRoleId(roleEntity.getRoleId());
        roleDto.setRoleName(roleEntity.getRoleName());
        List<String> privileges = new ArrayList<>();
        List<PrivilegeRoleEntity> privilegeRoleEntities = privilegeRoleRepository.
                findAllByRoleRoleId(roleEntity.getRoleId());
        privilegeRoleEntities.forEach(privilegeRoleEntity -> {
            privileges.add(privilegeRoleEntity.getPrivilege().getPriv());
        });
        roleDto.setPrivileges(privileges);
        return roleDto;
    }

   
}
