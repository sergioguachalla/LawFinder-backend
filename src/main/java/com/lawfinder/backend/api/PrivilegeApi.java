package com.lawfinder.backend.api;

import com.lawfinder.backend.bl.PrivilegeBl;
import com.lawfinder.backend.dto.PrivilegeDto;
import com.lawfinder.backend.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/privileges")
@CrossOrigin(origins = "*")
public class PrivilegeApi {
    @Autowired private PrivilegeBl privilegeBl;

    @PostMapping("/")
    public ResponseDto<String> savePrivilege(@RequestBody PrivilegeDto privilegeDto) {
        privilegeBl.savePrivilege(privilegeDto);
        return new ResponseDto<String>("0001", "Privilege saved successfully", null);
    }

    @PutMapping("/{privilegeId}")
    public ResponseDto<String> deletePrivilege(@PathVariable Long privilegeId) {
        privilegeBl.deletePrivilege(privilegeId);
        return new ResponseDto<String>("0002", "Privilege deleted successfully", null);
    }

    @PutMapping("/{privilegeId}/update")
    public ResponseDto<String> updatePrivilege(@RequestBody PrivilegeDto privilegeDto) {
        privilegeBl.updatePrivilege(privilegeDto);
        return new ResponseDto<String>("0003", "Privilege updated successfully", null);
    }

    @GetMapping("/")
    public ResponseDto<List<PrivilegeDto>> getPrivileges() {
        List<PrivilegeDto> privileges = privilegeBl.getPrivileges();
        return new ResponseDto<List<PrivilegeDto>>("0004", privileges, null);
    }
}
