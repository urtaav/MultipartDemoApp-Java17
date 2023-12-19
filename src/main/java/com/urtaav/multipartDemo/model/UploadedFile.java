package com.urtaav.multipartDemo.model;

import com.urtaav.multipartDemo.response.FileUploadResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Entity
public class UploadedFile {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    private String fileId;
    private String fileName;
    private String fileType;
    @Lob
    private byte[] fileData;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public FileUploadResponse toResponse() {
        FileUploadResponse response = new FileUploadResponse();
        String downloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/v1/download/")
                .path(this.getFileId())
                .toUriString();
        response.setDownloadUri(downloadUri);
        response.setFileId(this.getFileId());
        response.setFileType(this.getFileType());
        response.setUploadStatus(true);
        response.setMessage("File Uploaded Successfully!");
        return response;
    }
}
