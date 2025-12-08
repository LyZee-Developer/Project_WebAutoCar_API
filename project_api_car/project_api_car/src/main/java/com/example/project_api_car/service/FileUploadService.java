package com.example.project_api_car.service;

import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.upload.UploadDataModel;
import com.example.project_api_car.dto.UploadDto;
import com.example.project_api_car.util.UploadImageHandler;
@Service
public class FileUploadService {
    UploadImageHandler upload = new UploadImageHandler("car");
    public UploadDto uploadFile(UploadDataModel file) {
        var dto = upload.Upload(file);
        return dto;
    }
    public Boolean DeleteImage(String filename) {
        var isDeleteSuccess = upload.DeleteImage(filename);
        return isDeleteSuccess;
    }
}
