package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.FileEntity;
import com.lawfinder.backend.dao.FileRepository;
import com.lawfinder.backend.dto.FileDto;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileBl {
    private final FileRepository fileRepository;

    public FileBl(FileRepository fileRepository){
        this.fileRepository = fileRepository;
    }

    public void saveFile(FileDto file){
        FileEntity fileEntity = new FileEntity();
        fileEntity.setUrl(file.getUrl());
        fileEntity.setMimeType(file.getMimeType());
        fileEntity.setSize(file.getSize());
        fileEntity.setMd5(file.getMd5());
        fileEntity.setTxUser("lawfinder");
        fileEntity.setTxHost("localhost");
        fileEntity.setTxDate(file.getTxDate());

        // save file
        fileRepository.saveAndFlush(fileEntity);
    }

    public List<FileEntity> findAll(){
        return fileRepository.findAll();
    }

}
