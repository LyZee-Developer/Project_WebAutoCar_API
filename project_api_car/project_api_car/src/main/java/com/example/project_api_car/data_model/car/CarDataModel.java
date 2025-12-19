package com.example.project_api_car.data_model.car;

import com.example.project_api_car.data_model.IBaseDataModel;
import com.example.project_api_car.data_model.upload.UploadDataModel;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDataModel extends  IBaseDataModel{
    public Long id;
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    public String name;
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    public String englishName;
    public Boolean status;
    private UploadDataModel upload;
}
