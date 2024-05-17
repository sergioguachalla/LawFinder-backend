package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.PrivilegeEntity;
import com.lawfinder.backend.Entity.PrivilegeRoleEntity;
import com.lawfinder.backend.Entity.RoleEntity;
import com.lawfinder.backend.dao.PrivilegeRepository;
import com.lawfinder.backend.dao.PrivilegeRoleRepository;
import com.lawfinder.backend.dao.RoleRepository;
import com.lawfinder.backend.dto.PrivilegeRoleDto;
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
        roleEntity.setRoleName(roleDto.getRoleName());
        roleEntity.setStatus(1);
        roleRepository.save(roleEntity);
    }

    public void addPrivilegeToRole(PrivilegeRoleDto privilegeRoleDto){
        logger.info("RoleDto: {}", privilegeRoleDto.getRoleName());
        logger.info("RoleDto: {}", privilegeRoleDto.getPrivileges());
        RoleEntity role = new RoleEntity();
        role.setRoleName(privilegeRoleDto.getRoleName());
        role.setStatus(1);
        RoleEntity roleAux = roleRepository.save(role);


        //RoleEntity roleEntity = roleRepository.findById(roleId).orElseThrow();

        for (Long privilegeId : privilegeRoleDto.getPrivileges()) {
            PrivilegeEntity privilegeEntity = privilegeRepository.findById(privilegeId).orElseThrow();
            PrivilegeRoleEntity privilegeRoleEntity = new PrivilegeRoleEntity();
            privilegeRoleEntity.setRole(roleAux);
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

    public void deleteRole(Long roleId){
        List<PrivilegeRoleEntity> privilegeRoleEntities = privilegeRoleRepository.findAllByRoleRoleId(roleId);
        List<UserRoleEntity> userRoleEntities = userRoleRepository.findAllByRoleRoleId(roleId);
        for (UserRoleEntity userRoleEntity : userRoleEntities) {
            userRoleEntity.setStatus(false);
            userRoleRepository.save(userRoleEntity);
        }
        for (PrivilegeRoleEntity privilegeRoleEntity : privilegeRoleEntities) {
            privilegeRoleEntity.setStatus(0);
            privilegeRoleRepository.save(privilegeRoleEntity);
        }
        RoleEntity roleEntity = roleRepository.findById(roleId).orElseThrow();
        roleEntity.setStatus(0);
        roleRepository.save(roleEntity);

    }
  
  /**
  Ale
  **/

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
