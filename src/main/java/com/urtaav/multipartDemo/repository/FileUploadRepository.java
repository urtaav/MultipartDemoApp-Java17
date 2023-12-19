package com.urtaav.multipartDemo.repository;

import com.urtaav.multipartDemo.model.UploadedFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileUploadRepository extends JpaRepository<UploadedFile,String> {
}
