package com.example.project_api_car.data_model.portfolio;

import java.util.List;

import com.example.project_api_car.data_model.IBaseDataModel;
import com.example.project_api_car.data_model.upload.UploadDataModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PortfolioDataModel extends  IBaseDataModel{
    private List<UploadDataModel> uploads;
}
