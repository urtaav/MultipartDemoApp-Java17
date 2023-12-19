package com.urtaav.multipartDemo.service;

import com.urtaav.multipartDemo.model.UploadedFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileUploadService {

    public  void uploadToLocal(MultipartFile file);
    public  UploadedFile  uploadToDb(MultipartFile file);
    public UploadedFile downloadFile(String fileId);

    public List<UploadedFile> geAllFiles();
}
