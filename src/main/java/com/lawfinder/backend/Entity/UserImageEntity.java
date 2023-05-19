package com.lawfinder.backend.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "USER_IMAGE")
public class UserImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IMAGE_ID")
    private Long imageId;

    @Column(name = "FILE_ID", nullable = false)
    private FileEntity fileId;

    // Constructor
    public UserImageEntity() {
    }

    // Constructor con todos los atributos
    public UserImageEntity(FileEntity fileId) {
        this.fileId = fileId;
    }

    // Getters y setters

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public FileEntity getFileId() {
        return fileId;
    }

    public void setFileId(FileEntity fileId) {
        this.fileId = fileId;
    }

    // toString

    @Override
    public String toString() {
        return "UserImageEntity{" +
                "imageId=" + imageId +
                ", fileId=" + fileId +
                '}';
    }
}
