package com.lawfinder.backend.api;

import com.lawfinder.backend.bl.AuthBl;
import com.lawfinder.backend.bl.PrivilegeBl;
import com.lawfinder.backend.bl.TokenBl;
import com.lawfinder.backend.dto.PrivilegeDto;
import com.lawfinder.backend.dto.ResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/privileges")
@CrossOrigin(origins = "*")
public class PrivilegeApi {
    @Autowired private PrivilegeBl privilegeBl;
    @Autowired private AuthBl authBl;
    @Autowired private TokenBl tokenBl;

    @PostMapping("/")
    public ResponseDto<String> savePrivilege(
            @RequestBody PrivilegeDto privilegeDto,
            @RequestHeader("Authorization") String token,
            HttpServletRequest request

    ) {
        String ipAddress = authBl.getClientIp(request);
        ResponseDto<String> response = new ResponseDto<>();

        if(!authBl.validateToken(token)){
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            return response;
        }
        privilegeBl.savePrivilege(privilegeDto,tokenBl.getUsernameFromToken(token),ipAddress);
        return new ResponseDto<String>("0001", "Privilege saved successfully", null);
    }

    @PutMapping("/{privilegeId}")
    public ResponseDto<String> deletePrivilege(
            @PathVariable Long privilegeId,
            @RequestHeader("Authorization") String token,
            HttpServletRequest request
    ) {
        String ipAddress = authBl.getClientIp(request);
        ResponseDto<String> response = new ResponseDto<>();

        if(!authBl.validateToken(token)){
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            return response;
        }

        privilegeBl.deletePrivilege(privilegeId,tokenBl.getUsernameFromToken(token),ipAddress);
        return new ResponseDto<String>("0002", "Privilege deleted successfully", null);
    }

    @PutMapping("/{privilegeId}/update")
    public ResponseDto<String> updatePrivilege(
            @RequestBody PrivilegeDto privilegeDto,
            @RequestHeader("Authorization") String token,
            HttpServletRequest request
    ) {
        String ipAddress = authBl.getClientIp(request);
        ResponseDto<String> response = new ResponseDto<>();

        if(!authBl.validateToken(token)){
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            return response;
        }

        privilegeBl.updatePrivilege(privilegeDto,tokenBl.getUsernameFromToken(token),ipAddress);
        return new ResponseDto<String>("0003", "Privilege updated successfully", null);
    }

    @GetMapping("/")
    public ResponseDto<List<PrivilegeDto>> getPrivileges() {
        List<PrivilegeDto> privileges = privilegeBl.getPrivileges();
        return new ResponseDto<List<PrivilegeDto>>("0004", privileges, null);
    }
}
