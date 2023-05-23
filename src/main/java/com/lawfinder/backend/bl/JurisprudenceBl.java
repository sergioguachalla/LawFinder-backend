package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entity.FileEntity;
import com.lawfinder.backend.Entity.JurisprudenceEntity;
import com.lawfinder.backend.Entity.ProvinceEntity;
import com.lawfinder.backend.Entity.SubCategoryEntity;
import com.lawfinder.backend.dao.FileRepository;
import com.lawfinder.backend.dao.JurisprudenceRepository;
import com.lawfinder.backend.dto.FileDto;
import com.lawfinder.backend.dto.JurisprudenceDto;

import com.lawfinder.backend.dto.ProvinceDto;
import com.lawfinder.backend.dto.SubCategoryDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<JurisprudenceDto> findAll(){
        List<JurisprudenceEntity> jurisprudencesEntities = jurisprudenceRepository.findAll();
        List<JurisprudenceDto> jurisprudencesDtoList = new ArrayList<>();
        for (JurisprudenceEntity jurisprudenceEntity : jurisprudencesEntities) {
            JurisprudenceDto jurisprudenceDto = new JurisprudenceDto();
            jurisprudenceDto.setSentenceDate(jurisprudenceEntity.getSentenceDate());
            jurisprudenceDto.setSummary(jurisprudenceEntity.getSummary());
            jurisprudenceDto.setStatus(jurisprudenceEntity.getStatus());
            jurisprudenceDto.setTxDate(jurisprudenceEntity.getTxDate());
            jurisprudenceDto.setTxHost(jurisprudenceEntity.getTxHost());
            jurisprudenceDto.setTxUser(jurisprudenceEntity.getTxUser());
            jurisprudenceDto.setIdJurisprudence(jurisprudenceEntity.getId().longValue());
            FileEntity fileEntity = jurisprudenceEntity.getFileId();
            FileDto fileDto = new FileDto();
            fileDto.setFileId(fileEntity.getFileId());
            ProvinceEntity provinceEntity = jurisprudenceEntity.getProvId();
            ProvinceDto provinceDto = new ProvinceDto();
            provinceDto.setIdProvince(provinceEntity.getProvinceId());
            SubCategoryEntity subCategoryEntity = jurisprudenceEntity.getSubcategoryId();
            SubCategoryDto subCategoryDto = new SubCategoryDto();
            subCategoryDto.setIdSubCategory(subCategoryEntity.getSubCategoryId());
            jurisprudenceDto.setFileId(fileDto);
            jurisprudenceDto.setProvinceId(provinceDto);
            jurisprudenceDto.setSubcategoryId(subCategoryDto);
            jurisprudencesDtoList.add(jurisprudenceDto);
        }
        return jurisprudencesDtoList;



    }

}
