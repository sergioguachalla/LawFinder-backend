package com.lawfinder.backend.bl;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.IOUtils;
import com.lawfinder.backend.Entity.FileEntity;
import com.lawfinder.backend.dao.FileRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.lawfinder.backend.services.FileService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AwsS3Bl implements FileService{

    private String bucketName = "lawfinderdocs";
    private final FileRepository fileRepository;

    private  final AmazonS3 s3;

    public AwsS3Bl(AmazonS3 s3, FileRepository fileRepository) {
        this.s3 = s3;
        this.fileRepository = fileRepository;
    }

    @Override
    public String saveFile(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        int count = 0;
        int maxTries = 3;
        while (true) {
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
    
                return contentMd5;
            } catch (IOException e) {
                if (++count == maxTries) throw new RuntimeException(e);
            }
        }
    }

    @Override
    public byte[] downloadFile(String filename) {
        S3Object object = s3.getObject(bucketName, filename);
        S3ObjectInputStream objectContent = object.getObjectContent();
        try {
           return IOUtils.toByteArray(objectContent);
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }


    }

    @Override
    public String deleteFile(String filename) {

        s3.deleteObject(bucketName,filename);
        return "File deleted";
    }

    @Override
    public List<String> listAllFiles() {

        ListObjectsV2Result listObjectsV2Result = s3.listObjectsV2(bucketName);
      return  listObjectsV2Result.getObjectSummaries().stream().map(S3ObjectSummary::getKey).collect(Collectors.toList());

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
