package com.lawfinder.backend.api;

import com.amazonaws.Response;
import com.lawfinder.backend.bl.RoleBl;
import com.lawfinder.backend.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")

@RestController
public class RoleApi {
    @Autowired
    private RoleBl roleBl;

    public RoleApi(RoleBl roleBl) {
        this.roleBl = roleBl;
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
