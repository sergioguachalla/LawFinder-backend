package com.lawfinder.backend.bl;
import com.amazonaws.auth.SdkClock.Instance;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.IOUtils;
import com.lawfinder.backend.Entity.CourtEntity;
import com.lawfinder.backend.Entity.FileEntity;
import com.lawfinder.backend.Entity.InstanceLegalCaseEntity;
import com.lawfinder.backend.Entity.LegalFileEntity;
import com.lawfinder.backend.Entity.LegalFileTypeEntity;
import com.lawfinder.backend.dao.FileRepository;
import com.lawfinder.backend.dao.LegalFileRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LegalFileBl{

    private String bucketName = "lawfinderdocs";
    private final FileRepository fileRepository;
    private final LegalFileRepository legalFileRepository;

    private  final AmazonS3 s3;

    public LegalFileBl(AmazonS3 s3, FileRepository fileRepository, LegalFileRepository legalFileRepository) {
        this.s3 = s3;
        this.fileRepository = fileRepository;
        this.legalFileRepository = legalFileRepository;
    }

    
    public void saveFile(MultipartFile file,Integer instanceCaseId ,String summary, String dueDate, Integer courtId, Integer documentTypeId ) {
        String originalFilename = file.getOriginalFilename();
        
            try {
                File file1 = convertMultiPartToFile(file);
                PutObjectResult putObjectResult = s3.putObject(bucketName, originalFilename, file1);
                String contentMd5 = putObjectResult.getContentMd5();
    
                // Obtener la URL del archivo en Amazon S3

                String fileUrl = s3.getUrl(bucketName, originalFilename).toString();
    
                // Obtener el mimetype del archivo
                String mimeType = file.getContentType();
    
                // Obtener el tamaño del archivo
                long fileSize = file.getSize();
    
                // Guardar la información en la base de datos
                FileEntity fileEntity = new FileEntity();
                fileEntity.setUrl(fileUrl);
                fileEntity.setMimeType(mimeType);
                fileEntity.setSize(String.valueOf(fileSize)+" mb");
                fileEntity.setTxUser("admin");
                fileEntity.setTxHost("localhost");
                fileEntity.setTxDate(new java.util.Date());
                fileRepository.saveAndFlush(fileEntity);

                //Guardar la informacion de legal file a su respectiva bd
                LegalFileEntity legalFileEntity = new LegalFileEntity();
                CourtEntity courtEntity = new CourtEntity();
                LegalFileTypeEntity legalFileTypeEntity = new LegalFileTypeEntity();
                InstanceLegalCaseEntity instanceLegalCaseEntity = new InstanceLegalCaseEntity();

                legalFileTypeEntity.setLegalFileTypeId(Long.valueOf(documentTypeId));
                courtEntity.setCourtId(Long.valueOf(courtId));
                instanceLegalCaseEntity.setInstanceLegalCaseId(Long.valueOf(instanceCaseId));

                legalFileEntity.setFileId(fileEntity);
                legalFileEntity.setCourtId(courtEntity);
                legalFileEntity.setLegalFileTypeId(legalFileTypeEntity);
                legalFileEntity.setInstanceLegalCaseId(instanceLegalCaseEntity);
                legalFileEntity.setResolutionDate(new java.util.Date());
               // legalFileEntity.setSummary(summary);
                legalFileEntity.setTxUser("admin");
                legalFileEntity.setTxHost("localhost");
                legalFileEntity.setTxDate(new java.util.Date());
                legalFileRepository.saveAndFlush(legalFileEntity);
                

            } catch (IOException e) {
                e.printStackTrace();
            }
        
    }




    private File convertMultiPartToFile(MultipartFile file ) throws IOException
    {
        File convFile = new File( file.getOriginalFilename() );
        FileOutputStream fos = new FileOutputStream( convFile );
        fos.write( file.getBytes() );
        fos.close();
        return convFile;
    }
}