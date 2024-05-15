package com.lawfinder.backend.api;

import com.lawfinder.backend.bl.RoleBl;
import com.lawfinder.backend.dto.ResponseDto;
import com.lawfinder.backend.dto.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@CrossOrigin(origins = "*")
public class RoleApi {
    @Autowired private RoleBl roleBl;

    @PostMapping("/")
    public ResponseDto<String> saveRole(@RequestBody RoleDto roleDto){
        roleBl.saveRole(roleDto);
        return new ResponseDto<>("0001", "Role saved successfully", null);
    }

    @PostMapping("/privileges/")
    public ResponseDto<String> addPrivilegeToRole(@RequestParam("roleId") Long roleId,
                                                  @RequestBody List<Long> privileges) {
        roleBl.addPrivilegeToRole(roleId, privileges);
        return new ResponseDto<String>("0001", "Privilege added to role successfully", null);
    }

    @GetMapping("/")
    public ResponseDto<List<RoleDto>> findRoles() {
        return new ResponseDto<>("0001", roleBl.findRoles(), null );
    }
}
