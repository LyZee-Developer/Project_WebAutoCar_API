package com.example.project_api_car.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.project_api_car.dto.UploadDto;
import com.example.project_api_car.util.UploadImageHandler;
@Service
public class FileUploadService {
    UploadImageHandler upload = new UploadImageHandler("lyleangseng");
    public UploadDto uploadFile(MultipartFile file) {
        var dto = upload.Upload(file);
        return dto;
    }
    public Boolean DeleteImage(String filename) {
        var isDeleteSuccess = upload.DeleteImage(filename);
        return isDeleteSuccess;
    }
}
