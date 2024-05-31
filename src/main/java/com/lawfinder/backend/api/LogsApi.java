package com.lawfinder.backend.api;

import com.lawfinder.backend.bl.AuthBl;
import com.lawfinder.backend.bl.LogBl;
import com.lawfinder.backend.dto.ApplicationLogsDto;
import com.lawfinder.backend.dto.LogsCategoryDto;
import com.lawfinder.backend.dto.LogsLevelDto;
import com.lawfinder.backend.dto.ResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class LogsApi {
    @Autowired AuthBl authBl;
    @Autowired LogBl logBl;

    @GetMapping("/api/v1/logsLevel")
    public ResponseDto<List<LogsLevelDto>> getLogsLevel(){
        ResponseDto<List<LogsLevelDto>> response = new ResponseDto<>();
        response.setCode("0000");
        response.setResponse(logBl.getLogsLevel());
        response.setErrorMessage(null);
        return response;
    }

    @GetMapping("/api/v1/logsCategory")
    public ResponseDto<List<LogsCategoryDto>> getLogsCategory(){
        ResponseDto<List<LogsCategoryDto>> response = new ResponseDto<>();
        response.setCode("0000");
        response.setResponse(logBl.getLogsCategory());
        response.setErrorMessage(null);
        return response;
    }

    @GetMapping("/api/v1/applicationLogs")
    public ResponseDto<Page<ApplicationLogsDto>> getApplicationLogs(
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date to,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) Long levelId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestHeader("Authorization") String token,
            HttpServletRequest request
    ){
        ResponseDto<Page<ApplicationLogsDto>> response = new ResponseDto<>();
        String ipAddress = authBl.getClientIp(request);
        if(!authBl.validateToken(token)){
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            logBl.saveSecurityLog("desconocido", "intento de obtener logs de aplicacion sin autorizacion", ipAddress, 6L);
            return response;
        }
        response.setCode("0000");
        Pageable pageable = PageRequest.of(page, size);
        response.setResponse(logBl.getApplicationLogs(from, to, categoryId, levelId, pageable));
        response.setErrorMessage(null);
        return response;

    }



    @GetMapping("/api/v1/securityLogs")
    public ResponseDto<Page<ApplicationLogsDto>> getSecurityLogs(
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date to,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestHeader("Authorization") String token,
            HttpServletRequest request
    ){
        ResponseDto<Page<ApplicationLogsDto>> response = new ResponseDto<>();
        String ipAddress = authBl.getClientIp(request);
        if(!authBl.validateToken(token)){
            response.setCode("0001");
            response.setResponse(null);
            response.setErrorMessage("Invalid token");
            logBl.saveSecurityLog("desconocido", "intento de obtener logs de seguridad sin autorizacion", ipAddress, 6L);
            return response;
        }
        response.setCode("0000");
        Pageable pageable = PageRequest.of(page, size);
        response.setResponse(logBl.getSecurityLogs(from, to, categoryId, pageable));
        response.setErrorMessage(null);
        return response;

    }



}
