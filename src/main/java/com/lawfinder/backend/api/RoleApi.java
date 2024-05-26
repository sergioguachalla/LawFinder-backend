package com.lawfinder.backend.api;

import com.lawfinder.backend.bl.*;
import com.lawfinder.backend.dto.*;
import jakarta.servlet.http.HttpServletRequest;
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
    @Autowired private AuthBl authBl;
    @Autowired private TokenBl tokenBl;
    @Autowired private LogBl logBl;

    @PostMapping("/")
    public ResponseDto<String> saveRole(
            @RequestBody RoleDto roleDto,
            @RequestHeader("Authorization") String token,
            HttpServletRequest request

    ){
        String ipAddress = authBl.getClientIp(request);
        ResponseDto<String> response = new ResponseDto<>();
        if(!authBl.validateToken(token)) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            logBl.saveSecurityLog("desconocido", "intento de agregar roles sin autorizacion", ipAddress, 6L);
            return response;
        }
        roleBl.saveRole(roleDto,tokenBl.getUsernameFromToken(token),ipAddress);
        return new ResponseDto<>("0001", "Role saved successfully", null);
    }

    @PostMapping("/privileges/")
    public ResponseDto<String> addPrivilegeToRole(
            @RequestBody PrivilegeRoleDto privilegeRoleDto,
            @RequestHeader("Authorization") String token,
            HttpServletRequest request

    ) {
            String ipAddress = authBl.getClientIp(request);
            ResponseDto<String> response = new ResponseDto<>();
            if(!authBl.validateToken(token)) {
                response.setCode("0001");
                response.setResponse(null);
                response.setErrorMessage("Invalid token");
                logBl.saveSecurityLog("desconocido", "intento de agregar privilegios a roles sin autorizacion", ipAddress, 6L);
                return response;
            }
            roleBl.addPrivilegeToRole(privilegeRoleDto,tokenBl.getUsernameFromToken(token),ipAddress);
        return new ResponseDto<String>("0001", "Privilege added to role successfully", null);
    }

    @GetMapping("/")
    public ResponseDto<List<RoleDto>> findRoles() {
        return new ResponseDto<>("0001", roleBl.findRoles(), null );
    }


    @GetMapping("/{id}")
    public ResponseDto<RoleDto> findRoleById(@PathVariable Long id) {
        return new ResponseDto<>("0000", roleBl.findRoleById(id), null);
    }

    @PutMapping("/users/{id}/role/{role}/add")
    public ResponseDto<String> updateUserRole(
            @PathVariable Long id,
            @PathVariable Long role,
            @RequestHeader("Authorization") String token,
            HttpServletRequest request
            ) {
        try {
            String ipAddress = authBl.getClientIp(request);
            ResponseDto<String> response = new ResponseDto<>();
            if(!authBl.validateToken(token)) {
                response.setCode("0001");
                response.setResponse(null);
                response.setErrorMessage("Invalid token");
                logBl.saveSecurityLog("desconocido", "intento de actualizar roles sin autorizacion", ipAddress, 6L);
                return response;
            }
            this.roleBl.addUserRole(id, role,tokenBl.getUsernameFromToken(token),ipAddress);
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

    @PutMapping("/users/{id}/role/{role}/delete")
    public ResponseDto<String> deleteUserRole(
            @PathVariable Long id,
            @PathVariable Long role,
            @RequestHeader("Authorization") String token,
            HttpServletRequest request

    ) {
        try {
            String ipAddress = authBl.getClientIp(request);
            ResponseDto<String> response = new ResponseDto<>();
            if(!authBl.validateToken(token)) {
                response.setCode("0001");
                response.setResponse(null);
                response.setErrorMessage("Invalid token");
                logBl.saveSecurityLog("desconocido", "intento de eliminar roles sin autorizacion", ipAddress, 6L);
                return response;
            }
            this.roleBl.deleteUserRole(id, role,tokenBl.getUsernameFromToken(token),ipAddress);
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

    @DeleteMapping("/{roleId}")
    public ResponseDto<String> deleteRole(
            @PathVariable Long roleId,
            @RequestHeader("Authorization") String token,
            HttpServletRequest request

    ) {
        try{
            String ipAddress = authBl.getClientIp(request);
            ResponseDto<String> response = new ResponseDto<>();
            if(!authBl.validateToken(token)) {
                response.setCode("0001");
                response.setResponse(null);
                response.setErrorMessage("Invalid token");
                logBl.saveSecurityLog("desconocido", "intento de eliminar roles sin autorizacion", ipAddress, 6L);
                return response;
            }
            roleBl.deleteRole(roleId,tokenBl.getUsernameFromToken(token),ipAddress);
            return new ResponseDto<>("0000", "Role deleted successfully", null);
        }
        catch (Exception e) {
            ResponseDto<String> response = new ResponseDto<>();
            response.setCode("0001");
            response.setResponse("Error deleting role");
            return response;
        }
    }

    @GetMapping("/{roleId}/privileges")
    public ResponseDto<List<RoleUpdateDto>> findPrivilegesByRole(@PathVariable Long roleId) {
        ResponseDto<List<RoleUpdateDto>> response = new ResponseDto<>();

        try {
            return new ResponseDto<>("0000", roleBl.findPrivilegesByRole(roleId), null);
        } catch (Exception e) {
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Error finding privileges");
            return response;
        }
    }

    @PutMapping("/{roleId}/privileges")
    public ResponseDto<String> updatePrivilegesByRoleId(@PathVariable Long roleId, @RequestBody List<RoleUpdateDto> roleUpdateDtos) {
        try {
            roleBl.updatePrivilegesByRoleId(roleId, roleUpdateDtos);
            return new ResponseDto<>("0000", "Privileges updated successfully", null);
        } catch (Exception e) {
            return new ResponseDto<>("0001", "Error updating privileges", null);
        }
    }

    @PutMapping("/{roleId}/update")
    public ResponseDto<String> updateRole(
            @RequestBody RoleDto roleDto,
            @RequestHeader("Authorization") String token,
            HttpServletRequest request

    ) {
        String ipAddress = authBl.getClientIp(request);
        if(!authBl.validateToken(token)) {
            logBl.saveSecurityLog("desconocido", "intento de actualizar roles sin autorizacion", ipAddress, 6L);
            return new ResponseDto<>("0001", "Invalid token", null);
        }
        roleBl.updateRole(roleDto,tokenBl.getUsernameFromToken(token),ipAddress);
        return new ResponseDto<>("0001", "Role updated successfully", null);
    }




}
