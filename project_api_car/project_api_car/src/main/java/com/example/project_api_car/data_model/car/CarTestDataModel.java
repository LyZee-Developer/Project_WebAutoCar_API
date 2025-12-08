package com.example.project_api_car.data_model.car;

import com.example.project_api_car.data_model.upload.UploadDataModel;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarTestDataModel{
    private Long Id;
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    private String Name;
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    private String EnglishName;
    private Boolean Status;
    private UploadDataModel upload;
}
