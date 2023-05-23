package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.FileEntity;
import com.lawfinder.backend.Entity.JurisprudenceEntity;
import com.lawfinder.backend.Entity.ProvinceEntity;
import com.lawfinder.backend.Entity.SubCategoryEntity;
import com.lawfinder.backend.dao.FileRepository;
import com.lawfinder.backend.dao.JurisprudenceRepository;
import com.lawfinder.backend.dto.JurisprudenceDto;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JurisprudenceBl {
    private final JurisprudenceRepository jurisprudenceRepository;
    private final FileRepository fileRepository;
    public JurisprudenceBl(JurisprudenceRepository jurisprudenceRepository, FileRepository fileRepository){
        this.jurisprudenceRepository = jurisprudenceRepository;
        this.fileRepository = fileRepository;
    }

    public void saveJurisprudence(JurisprudenceDto jurisprudence){
        JurisprudenceEntity jurisprudenceEntity= new JurisprudenceEntity();
        FileEntity fileEntity = new FileEntity();
        ProvinceEntity provinceEntity = new ProvinceEntity();
        provinceEntity.setProvinceId(jurisprudence.getProvinceId().getIdProvince());
        provinceEntity.setProvinceName(jurisprudence.getProvinceId().getProvinceName());

        SubCategoryEntity subCategoryEntity = new SubCategoryEntity();
        subCategoryEntity.setSubCategoryId(jurisprudence.getSubcategoryId().getIdSubCategory());
        subCategoryEntity.setSubCatName(jurisprudence.getSubcategoryId().getSubCategoryName());


        fileEntity.setUrl(jurisprudence.getFileId().getUrl());
        fileEntity.setMimeType(jurisprudence.getFileId().getMimeType());
        fileEntity.setSize(jurisprudence.getFileId().getSize());
        fileEntity.setMd5(jurisprudence.getFileId().getMd5());
        fileEntity.setTxUser("lawfinder");
        fileEntity.setTxHost("localhost");
        fileEntity.setTxDate(jurisprudence.getFileId().getTxDate());
        fileRepository.save(fileEntity);

        jurisprudenceEntity.setSentenceDate(jurisprudence.getSentenceDate());
        jurisprudenceEntity.setSummary(jurisprudence.getSummary());
        jurisprudenceEntity.setStatus(jurisprudence.getStatus());
        jurisprudenceEntity.setProvId(provinceEntity);
        jurisprudenceEntity.setSubcategoryId(subCategoryEntity);
        jurisprudenceEntity.setFileId(fileEntity);
        jurisprudenceEntity.setTxUser("lawfinder");
        jurisprudenceEntity.setTxHost("localhost");
        jurisprudenceEntity.setTxDate(jurisprudence.getTxDate());

        jurisprudenceRepository.save(jurisprudenceEntity);
        
    }

    public List<JurisprudenceEntity> findAll(){
        return jurisprudenceRepository.findAll();
    }

}
