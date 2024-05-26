package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.ApplicationLogEntity;
import com.lawfinder.backend.Entity.LogCategoryEntity;
import com.lawfinder.backend.dao.ApplicationLogRepository;
import com.lawfinder.backend.dao.LogCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LogBl {
    @Autowired private ApplicationLogRepository applicationLogRepository;
    @Autowired private LogCategoryRepository logCategoryRepository;

    public void saveLog(String userLog, String description, String level, String host, Long categoryId){
        LogCategoryEntity logCategoryEntity = new LogCategoryEntity();
        logCategoryEntity = logCategoryRepository.findById(categoryId).get();
        ApplicationLogEntity applicationLogEntity = new ApplicationLogEntity();
        applicationLogEntity.setUserLog(userLog);
        applicationLogEntity.setDate(LocalDateTime.now());
        applicationLogEntity.setHost(host);
        applicationLogEntity.setDescription(description);
        applicationLogEntity.setLevel(level);
        applicationLogEntity.setCategory(logCategoryEntity);
        applicationLogRepository.saveAndFlush(applicationLogEntity);
    }



}
