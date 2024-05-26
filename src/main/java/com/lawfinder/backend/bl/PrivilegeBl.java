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
    @Autowired private LogBl logBl;

    Logger logger = Logger.getLogger(PrivilegeBl.class.getName());

    public void savePrivilege(PrivilegeDto privilegeDto, String username, String ipAddress) {
        logger.info("Saving privilege " + privilegeDto.getPrivilege());
        PrivilegeEntity privilege = new PrivilegeEntity();
        privilege.setPriv(privilegeDto.getPrivilege());
        privilege.setStatus(1);
        privilegeRepository.save(privilege);
        logBl.saveLog(username, "Privilege saved with id"+privilege.getPrivilegeId(), 1L,ipAddress,1L);
    }

    public void deletePrivilege(Long privilegeId, String username, String ipAddress) {
        logger.info("Deleting privilege with id " + privilegeId);
        PrivilegeEntity privilege = privilegeRepository.findById(privilegeId).orElseThrow();
        privilege.setStatus(0);
        privilegeRepository.save(privilege);
        logger.info("Privilege deleted successfully");
        logBl.saveLog(username, "Privilege deleted with id"+privilege.getPrivilegeId(), 2L,ipAddress,3L);

    }

    public void updatePrivilege(PrivilegeDto privilegeDto, String username, String ipAddress) {
        logger.info("Updating privilege " + privilegeDto.getPrivilege());
        PrivilegeEntity privilege = privilegeRepository.findById(privilegeDto.getPrivilegeId()).orElseThrow();
        privilege.setPriv(privilegeDto.getPrivilege());
        privilegeRepository.save(privilege);
        logBl.saveLog(username, "Privilege updated with id"+privilege.getPrivilegeId(), 2L,ipAddress,2L);
    }

    public List<PrivilegeDto> getPrivileges() {
        List<PrivilegeEntity> privileges = privilegeRepository.findAllByStatus(1);
        return privileges.stream().map(privilege -> new PrivilegeDto(privilege.getPrivilegeId(), privilege.getPriv())).toList();
    }
}
