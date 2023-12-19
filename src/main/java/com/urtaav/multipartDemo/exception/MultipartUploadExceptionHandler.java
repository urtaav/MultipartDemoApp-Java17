package com.urtaav.multipartDemo.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@RestControllerAdvice
public class MultipartUploadExceptionHandler {
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public String handleFileUploadException(MaxUploadSizeExceededException exception, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
    {
        return "File Size limit exceeded. Please make sure the file size is well within 128KB";
    }
}
