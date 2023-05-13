package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entitity.FileEntity;
import com.lawfinder.backend.dao.FileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileBl {
    private final FileRepository fileRepository;

    public FileBl(FileRepository fileRepository){
        this.fileRepository = fileRepository;
    }

    public FileEntity saveFile(FileEntity fileEntity){
        return fileRepository.save(fileEntity);
    }

    public List<FileEntity> findAll(){
        return fileRepository.findAll();
    }

}
