package com.lawfinder.backend.api;

import com.lawfinder.backend.bl.RoleBl;
import com.lawfinder.backend.dto.ResponseDto;
import com.lawfinder.backend.dto.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.amazonaws.Response;
import com.lawfinder.backend.bl.RoleBl;
import com.lawfinder.backend.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PutMapping("/api/v1/user/{id}/role/{role}/add")
    public ResponseDto<String> updateUserRole(@PathVariable Long id, @PathVariable Long role) {
        try {
            this.roleBl.addUserRole(id, role);
            ResponseDto<String> response = new ResponseDto<>();
            response.setCode("0000");
            response.setResponse("Role updated");
            return response;
        } catch (Exception e) {
            ResponseDto<String> response = new ResponseDto<>();
            response.setCode("0001");
            response.setResponse("Error updating role");
            return response;
        }
    }

    @PutMapping("/api/v1/user/{id}/role/{role}/delete")
    public ResponseDto<String> deleteUserRole(@PathVariable Long id, @PathVariable Long role) {
        try {
            this.roleBl.deleteUserRole(id, role);
            ResponseDto<String> response = new ResponseDto<>();
            response.setCode("0000");
            response.setResponse("Role deleted");
            return response;
        } catch (Exception e) {
            ResponseDto<String> response = new ResponseDto<>();
            response.setCode("0001");
            response.setResponse("Error deleting role");
            return response;
        }
    }




}
