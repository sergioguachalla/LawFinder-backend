package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.ApplicationLogEntity;
import com.lawfinder.backend.Entity.LogCategoryEntity;
import com.lawfinder.backend.Entity.LogLevelEntity;
import com.lawfinder.backend.Entity.SecurityLogEntity;
import com.lawfinder.backend.dao.ApplicationLogRepository;
import com.lawfinder.backend.dao.LogCategoryRepository;
import com.lawfinder.backend.dao.LogLevelRepository;
import com.lawfinder.backend.dao.SecurityLogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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




}
