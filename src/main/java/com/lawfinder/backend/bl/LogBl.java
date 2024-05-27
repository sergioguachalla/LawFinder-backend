package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.ApplicationLogEntity;
import com.lawfinder.backend.Entity.LogCategoryEntity;
import com.lawfinder.backend.Entity.LogLevelEntity;
import com.lawfinder.backend.Entity.SecurityLogEntity;
import com.lawfinder.backend.dao.ApplicationLogRepository;
import com.lawfinder.backend.dao.LogCategoryRepository;
import com.lawfinder.backend.dao.LogLevelRepository;
import com.lawfinder.backend.dao.SecurityLogsRepository;
import com.lawfinder.backend.dto.ApplicationLogsDto;
import com.lawfinder.backend.dto.LogsCategoryDto;
import com.lawfinder.backend.dto.LogsLevelDto;
import com.lawfinder.backend.specifications.LogsSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class LogBl {
    @Autowired private ApplicationLogRepository applicationLogRepository;
    @Autowired private LogCategoryRepository logCategoryRepository;
    @Autowired private LogLevelRepository logLevelRepository;
    @Autowired private SecurityLogsRepository securityLogsRepository;

    public void saveLog(String userLog, String description, Long levelId, String host, Long categoryId){
        LogCategoryEntity logCategoryEntity = new LogCategoryEntity();
        logCategoryEntity = logCategoryRepository.findById(categoryId).get();
        LogLevelEntity level = new LogLevelEntity();
        level = logLevelRepository.findById(levelId).get();


        ApplicationLogEntity applicationLogEntity = new ApplicationLogEntity();
        applicationLogEntity.setUserLog(userLog);
        applicationLogEntity.setDate(LocalDateTime.now());
        applicationLogEntity.setHost(host);
        applicationLogEntity.setDescription(description);
        applicationLogEntity.setLevel(level);
        applicationLogEntity.setCategory(logCategoryEntity);
        applicationLogRepository.saveAndFlush(applicationLogEntity);
    }

    public void saveSecurityLog(String userLog, String description,  String host, Long categoryId) {
        LogCategoryEntity logCategoryEntity = new LogCategoryEntity();
        logCategoryEntity = logCategoryRepository.findById(categoryId).get();
        SecurityLogEntity securityLogEntity = new SecurityLogEntity();
        securityLogEntity.setUserLog(userLog);
        securityLogEntity.setDate(LocalDateTime.now());
        securityLogEntity.setHost(host);
        securityLogEntity.setDescription(description);
        securityLogEntity.setCategory(logCategoryEntity);
        securityLogsRepository.saveAndFlush(securityLogEntity);
    }

    public Page<ApplicationLogsDto> getApplicationLogs(Date from, Date to, Long categoryId, Long level, Pageable pageable){
        Specification<ApplicationLogEntity> spec= Specification.where(null);
        if(from != null && to != null){
            spec= spec.and(LogsSpecifications.startDateBetween(from, to));
        }
        if(categoryId != null){
            spec= spec.and(LogsSpecifications.hasCategory(categoryId));
        }
        if(level != null){
            spec= spec.and(LogsSpecifications.hasLogLevel(level));
        }
        return applicationLogRepository.findAll(spec, pageable).map(this::mapToDto);

    }

    private ApplicationLogsDto mapToDto(ApplicationLogEntity applicationLogEntity){
        ApplicationLogsDto applicationLogsDto = new ApplicationLogsDto();
        applicationLogsDto.setLogId(applicationLogEntity.getLogId());
        applicationLogsDto.setUsername(applicationLogEntity.getUserLog());
        applicationLogsDto.setLogDate(applicationLogEntity.getDate());
        applicationLogsDto.setHost(applicationLogEntity.getHost());
        applicationLogsDto.setDescription(applicationLogEntity.getDescription());
        applicationLogsDto.setLevel(applicationLogEntity.getLevel().getLevelName());
        applicationLogsDto.setCategory(applicationLogEntity.getCategory().getCategoryName());
        return applicationLogsDto;
    }


    //SECURITY LOGS

    public Page<ApplicationLogsDto> getSecurityLogs(Date from, Date to, Long categoryId, Pageable pageable){
        Specification<SecurityLogEntity> spec= Specification.where(null);
        if(from != null && to != null){
            spec= spec.and(LogsSpecifications.startDateBetweenSecurity(from, to));
        }
        if(categoryId != null){
            spec= spec.and(LogsSpecifications.hasCategorySecurity(categoryId));
        }
        return securityLogsRepository.findAll(spec, pageable).map(this::mapToDtoSecurity);

    }

    private ApplicationLogsDto mapToDtoSecurity(SecurityLogEntity securityLogEntity){
        ApplicationLogsDto applicationLogsDto = new ApplicationLogsDto();
        applicationLogsDto.setLogId(securityLogEntity.getLogId());
        applicationLogsDto.setUsername(securityLogEntity.getUserLog());
        applicationLogsDto.setLogDate(securityLogEntity.getDate());
        applicationLogsDto.setHost(securityLogEntity.getHost());
        applicationLogsDto.setDescription(securityLogEntity.getDescription());
        applicationLogsDto.setLevel(securityLogEntity.getCategory().getCategoryName());
        applicationLogsDto.setCategory(securityLogEntity.getCategory().getCategoryName());
        return applicationLogsDto;
    }


    public List<LogsLevelDto> getLogsLevel(){
        List<LogLevelEntity> logLevelEntities = logLevelRepository.findAll();
        return logLevelEntities.stream().map(this::mapTogetLogsLevelDto).toList();
    }

    private LogsLevelDto mapTogetLogsLevelDto(LogLevelEntity logLevelEntity){
        return new LogsLevelDto(logLevelEntity.getLevelId(), logLevelEntity.getLevelName());
    }

    public List<LogsCategoryDto> getLogsCategory(){
        List<LogCategoryEntity> logCategoryEntities = logCategoryRepository.findAll();
        return logCategoryEntities.stream().map(this::mapTogetLogsCategoryDto).toList();
    }

    private LogsCategoryDto mapTogetLogsCategoryDto(LogCategoryEntity logCategoryEntity){
        return new LogsCategoryDto(logCategoryEntity.getCategoryId(), logCategoryEntity.getCategoryName());
    }




}
