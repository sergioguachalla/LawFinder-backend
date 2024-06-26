package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.PrivilegeEntity;
import com.lawfinder.backend.Entity.PrivilegeRoleEntity;
import com.lawfinder.backend.Entity.RoleEntity;
import com.lawfinder.backend.dao.PrivilegeRepository;
import com.lawfinder.backend.dao.PrivilegeRoleRepository;
import com.lawfinder.backend.dao.RoleRepository;
import com.lawfinder.backend.dto.PrivilegeRoleDto;
import com.lawfinder.backend.dto.RoleDto;
import com.lawfinder.backend.dto.RoleUpdateDto;
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
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PrivilegeRoleRepository privilegeRoleRepository;
    @Autowired
    private PrivilegeRepository privilegeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired LogBl logBl;
    /**
     * Sergio
     **/
    private final Logger logger = LoggerFactory.getLogger(RoleBl.class);

    public void saveRole(RoleDto roleDto, String username, String ipAddress) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleName(roleDto.getRoleName());
        roleEntity.setStatus(1);
        roleRepository.save(roleEntity);
        logBl.saveLog(username,"Rol"+ roleDto.getRoleName()+" creado",1L,ipAddress,1L);
    }

    public void addPrivilegeToRole(PrivilegeRoleDto privilegeRoleDto, String username, String ipAddress) {
        logger.info("RoleDto: {}", privilegeRoleDto.getRoleName());
        logger.info("RoleDto: {}", privilegeRoleDto.getPrivileges());
        RoleEntity role = new RoleEntity();
        role.setRoleName(privilegeRoleDto.getRoleName());
        role.setStatus(1);
        RoleEntity roleAux = roleRepository.save(role);

        for (Long privilegeId : privilegeRoleDto.getPrivileges()) {
            PrivilegeEntity privilegeEntity = privilegeRepository.findById(privilegeId).orElseThrow();
            PrivilegeRoleEntity privilegeRoleEntity = new PrivilegeRoleEntity();
            privilegeRoleEntity.setRole(roleAux);
            privilegeRoleEntity.setPrivilege(privilegeEntity);
            privilegeRoleEntity.setStatus(1);

            privilegeRoleRepository.save(privilegeRoleEntity);
        }
        logBl.saveLog(username,"Privilegio agregado a "+ privilegeRoleDto.getRoleName(),1L,ipAddress,1L);

    }

    public List<RoleDto> findRoles() {
        List<RoleEntity> roleEntities = roleRepository.findAllActiveRoles();

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

    public void deleteRole(Long roleId,String username, String ipAddress) {
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

        logBl.saveLog(username,"Rol "+ roleEntity.getRoleName()+ " eliminado ",2L,ipAddress,3L);
    }

    public void updateRole(RoleDto roleDto, String username, String ipAddress) {
        RoleEntity roleEntity = roleRepository.findById(roleDto.getRoleId()).orElseThrow();
        roleEntity.setRoleName(roleDto.getRoleName());
        List<String> privileges = roleDto.getPrivileges();
        for (String privilege : privileges) {
            PrivilegeEntity privilegeEntity = privilegeRepository.findByPriv(privilege);
            PrivilegeRoleEntity privilegeRoleEntity = new PrivilegeRoleEntity();
            privilegeRoleEntity.setRole(roleEntity);
            privilegeRoleEntity.setPrivilege(privilegeEntity);
            privilegeRoleEntity.setStatus(1);
            privilegeRoleRepository.save(privilegeRoleEntity);
        }
        logBl.saveLog(username,"Rol "+ roleEntity.getRoleName()+" Actualizado",1L,ipAddress,1L);

    }
  
  /**
  Ale handsome
  **/

 public void deleteUserRole(Long userId, Long roleId, String username, String ipAddress){
        UserRoleEntity userRoleEntity = userRoleRepository.findByUser_IdAndRole_Id(userId, roleId);
        userRoleEntity.setStatus(false);
        userRoleRepository.save(userRoleEntity);
        logBl.saveLog(username,"Rol eliminado al usuario: " + userId,2L,ipAddress,3L);
    }

    //add new Role
    public void addUserRole(Long userId, Long roleId, String username, String ipAddress){
        //verificar si el user role ya lo tenia pero estaba en false
        UserRoleEntity userRoleEntity = userRoleRepository.findWithoutStatus(userId, roleId);
        if(userRoleEntity != null){
            userRoleEntity.setStatus(true);
            userRoleRepository.save(userRoleEntity);
            logBl.saveLog(username,"Rol agregado  al userId: " + userId,1L,ipAddress,1L);

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

        logBl.saveLog(username,"Rol "+ roleEntity.getRoleName()+" agregado "+" al userId: " + userId,1L,ipAddress,1L);
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

    public  List<RoleUpdateDto> findPrivilegesByRole(Long id){
        List<RoleUpdateDto> roleUpdateDtos = new ArrayList<>();
        List<PrivilegeEntity> allprivileges = privilegeRepository.findAll();
        List<PrivilegeRoleEntity> privilegeRoleEntities = privilegeRoleRepository.findAllByRoleRoleId(id);
        //de todos los privilegios, devolver todos pero diciendo que rol tiene cada uno
        for (PrivilegeEntity privilegeEntity : allprivileges) {
            RoleUpdateDto roleUpdateDto = new RoleUpdateDto();
            roleUpdateDto.setPrivilegeId(privilegeEntity.getPrivilegeId());
            roleUpdateDto.setPrivilege(privilegeEntity.getPriv());
            roleUpdateDto.setStatus(false);
            for (PrivilegeRoleEntity privilegeRoleEntity : privilegeRoleEntities) {
                if(privilegeRoleEntity.getPrivilege().getPrivilegeId() == privilegeEntity.getPrivilegeId()){
                    roleUpdateDto.setStatus(true);
                    break;
                }
            }
            roleUpdateDtos.add(roleUpdateDto);
        }
        return roleUpdateDtos;
    }

    public void updatePrivilegesByRoleId (Long roleId, List<RoleUpdateDto> roleUpdateDtos){

        List<PrivilegeRoleEntity> privilegeRoleEntities = privilegeRoleRepository.findAllByRoleRoleId(roleId);
        for(RoleUpdateDto role: roleUpdateDtos){
            if(role.isStatus()){
                boolean exist = false;
                for(PrivilegeRoleEntity privilegeRoleEntity: privilegeRoleEntities){
                    if(privilegeRoleEntity.getPrivilege().getPrivilegeId() == role.getPrivilegeId()){
                        exist = true;
                        break;
                    }
                }
                if(!exist){
                    PrivilegeRoleEntity privilegeRoleEntity = new PrivilegeRoleEntity();
                    RoleEntity roleEntity = roleRepository.findByRoleId(roleId);
                    PrivilegeEntity privilegeEntity = privilegeRepository.findById(role.getPrivilegeId()).orElseThrow();
                    privilegeRoleEntity.setRole(roleEntity);
                    privilegeRoleEntity.setPrivilege(privilegeEntity);
                    privilegeRoleEntity.setStatus(1);
                    privilegeRoleRepository.save(privilegeRoleEntity);
                }
            }else{
                for(PrivilegeRoleEntity privilegeRoleEntity: privilegeRoleEntities){
                    if(privilegeRoleEntity.getPrivilege().getPrivilegeId() == role.getPrivilegeId()){
                        privilegeRoleEntity.setStatus(0);
                        privilegeRoleRepository.save(privilegeRoleEntity);
                        break;
                    }
                }
            }
        }

        logBl.saveLog("admin_sudo","Privilegios actualizados para el rol: "+ roleId,1L,"127.0.0.1",1L);



    }

   
}
