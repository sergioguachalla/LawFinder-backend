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

@Service
public class RoleBl {
    @Autowired private RoleRepository roleRepository;
    @Autowired private PrivilegeRoleRepository privilegeRoleRepository;
    @Autowired private PrivilegeRepository privilegeRepository;

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

    public void addPrivilegeToRole(Long roleId, Long privilegeId) {
        PrivilegeEntity privilegeEntity = privilegeRepository.findById(privilegeId).orElseThrow();
        RoleEntity roleEntity = roleRepository.findById(roleId).orElseThrow();
        PrivilegeRoleEntity privilegeRoleEntity = new PrivilegeRoleEntity();
        privilegeRoleEntity.setRole(roleEntity);
        privilegeRoleEntity.setPrivilege(privilegeEntity);
        privilegeRoleEntity.setStatus(1);
        privilegeRoleRepository.save(privilegeRoleEntity);
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
}
