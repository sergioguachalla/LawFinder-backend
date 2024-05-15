package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.PrivilegeEntity;
import com.lawfinder.backend.dao.PrivilegeRepository;
import com.lawfinder.backend.dto.PrivilegeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PrivilegeBl {
    @Autowired private PrivilegeRepository privilegeRepository;

    Logger logger = Logger.getLogger(PrivilegeBl.class.getName());

    public void savePrivilege(PrivilegeDto privilegeDto) {
        logger.info("Saving privilege " + privilegeDto.getPrivilege());
        PrivilegeEntity privilege = new PrivilegeEntity();
        privilege.setPriv(privilegeDto.getPrivilege());
        privilege.setStatus(1);
        privilegeRepository.save(privilege);
    }

    public void deletePrivilege(Long privilegeId) {
        logger.info("Deleting privilege with id " + privilegeId);
        PrivilegeEntity privilege = privilegeRepository.findById(privilegeId).orElseThrow();
        privilege.setStatus(0);
        privilegeRepository.save(privilege);
        logger.info("Privilege deleted successfully");

    }

    public void updatePrivilege(PrivilegeDto privilegeDto) {
        logger.info("Updating privilege " + privilegeDto.getPrivilege());
        PrivilegeEntity privilege = privilegeRepository.findById(privilegeDto.getPrivilegeId()).orElseThrow();
        privilege.setPriv(privilegeDto.getPrivilege());
        privilegeRepository.save(privilege);
    }

    public List<PrivilegeDto> getPrivileges() {
        List<PrivilegeEntity> privileges = privilegeRepository.findAllByStatus(1);
        return privileges.stream().map(privilege -> new PrivilegeDto(privilege.getPrivilegeId(), privilege.getPriv())).toList();
    }
}
