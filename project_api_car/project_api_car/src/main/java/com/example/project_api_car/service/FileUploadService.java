package com.example.project_api_car.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.project_api_car.dto.UploadDto;
import com.example.project_api_car.util.UploadImageHandler;
@Service
public class FileUploadService {
    public UploadDto uploadFile(MultipartFile file) {
        var upload = new UploadImageHandler("lyleangseng");
        var dto = upload.Upload(file);
        return dto;
    }
}
