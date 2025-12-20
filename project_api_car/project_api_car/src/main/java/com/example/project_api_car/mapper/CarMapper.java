package com.example.project_api_car.mapper;


import java.util.Date;

import com.example.project_api_car.data_model.car.CarDataModel;
import com.example.project_api_car.dto.CarDto;
import com.example.project_api_car.entity.DB_CAR;
import com.example.project_api_car.helper.GlobalHelper;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public class CarMapper {
    public  static DB_CAR MaptoEntity(CarDataModel model){
        var data = new DB_CAR();
        data.setName(model.getName());
        data.setNameEn(model.getEnglishName());
        data.setStatus(model.getStatus());
        data.setCreatedBy(GlobalHelper.Str.ADMIN);
        data.setCreatedDate(new Date());
        data.setDbCode(GlobalHelper.Str.GlobalDatabase);
        return data;
    }
    public  static CarDto MaptoDto(DB_CAR model,int recordCount,String PathImage){
        var data = new CarDto();
        data.setId(model.getId());
        data.setName(model.getName());
        data.setStatus(model.getStatus());
        data.setEnglishName(model.getNameEn());
        data.setCreatedBy(model.getCreatedBy());
        data.setCreatedDate(model.getCreatedDate());
        data.setRecordCount(recordCount);
        data.setPathImage(PathImage);
        data.setDatabase(model.getDbCode());
        data.setUpdatedBy(model.getUpdatedBy());
        data.setUpdatedDate(model.getUpdatedDate());
        return data;
    }
}
