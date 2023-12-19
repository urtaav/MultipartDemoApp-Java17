package com.urtaav.multipartDemo.service.serviceImpl;

import com.urtaav.multipartDemo.model.UploadedFile;
import com.urtaav.multipartDemo.repository.FileUploadRepository;
import com.urtaav.multipartDemo.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@Service
public class FileUploadServiceImpl implements FileUploadService {
    private  String uploadFolderPath ="C:\\opt\\servidores\\filedocs\\demoSpring";
    @Autowired
    private FileUploadRepository fileUploadRepository;

    @Override
    public void uploadToLocal(MultipartFile file) {
        try {
            byte[] data = file.getBytes();
            Path path = Paths.get(uploadFolderPath + file.getOriginalFilename());
            Files.write(path,data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UploadedFile  uploadToDb(MultipartFile file) {
        UploadedFile uploadedFile = new UploadedFile();
        try {
            uploadedFile.setFileData(file.getBytes());
            uploadedFile.setFileType(file.getContentType());
            uploadedFile.setFileName(file.getOriginalFilename());
            UploadedFile uploadedFileToRet = fileUploadRepository.save(uploadedFile);
            return uploadedFileToRet;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public UploadedFile downloadFile(String fileId) {
        return fileUploadRepository.getOne(fileId);
    }

    @Override
    public List<UploadedFile> geAllFiles() {
        return fileUploadRepository.findAll();
    }
}
