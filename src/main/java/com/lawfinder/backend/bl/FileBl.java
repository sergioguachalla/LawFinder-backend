package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.FileEntity;
import com.lawfinder.backend.dao.FileRepository;
import com.lawfinder.backend.dao.LegalFileRepository;
import com.lawfinder.backend.dto.FileDto;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FileBl {
    private final FileRepository fileRepository;
    private final LegalFileRepository legalFileRepository;
    public FileBl(FileRepository fileRepository, LegalFileRepository legalFileRepository){
        this.fileRepository = fileRepository;
        this.legalFileRepository = legalFileRepository;
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

    public List<FileDto> findAll(){

        List<FileEntity> filesEntityList = this.fileRepository.findAll();

        List<FileDto> filesDtoList = new ArrayList<>();
        for (FileEntity fileEntity : filesEntityList) {

            FileDto fileDto = new FileDto();
            fileDto.setFileId(fileEntity.getFileId());
            fileDto.setUrl(fileEntity.getUrl());
            fileDto.setMimeType(fileEntity.getMimeType());
            fileDto.setSize(fileEntity.getSize());
            fileDto.setMd5(fileEntity.getMd5());
            fileDto.setTxUser(fileEntity.getTxUser());
            fileDto.setTxHost(fileEntity.getTxHost());
            fileDto.setTxDate(fileEntity.getTxDate());
            filesDtoList.add(fileDto);
        }
        return filesDtoList;
    }

    public FileDto findById(Long id){
       FileEntity fileEntity = this.fileRepository.findByFileId(id);

       FileDto fileDto = new FileDto();
        if (fileEntity != null) {

           // FileDto fileDto = new FileDto();
            fileDto.setFileId(fileEntity.getFileId());
            fileDto.setUrl(fileEntity.getUrl());
            fileDto.setMimeType(fileEntity.getMimeType());
            fileDto.setSize(fileEntity.getSize());
            fileDto.setMd5(fileEntity.getMd5());
            fileDto.setTxUser(fileEntity.getTxUser());
            fileDto.setTxHost(fileEntity.getTxHost());
            fileDto.setTxDate(fileEntity.getTxDate());

        }
        return fileDto;

    }





}
