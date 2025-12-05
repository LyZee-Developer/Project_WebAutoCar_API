package com.example.project_api_car.mapper;


import java.util.Date;

import com.example.project_api_car.data_model.car.CarDataModel;
import com.example.project_api_car.dto.CarDto;
import com.example.project_api_car.entity.DB_CAR;
import com.example.project_api_car.helper.GlobalHelper;

public class CarMapper {
    public  static DB_CAR MaptoEntity(CarDataModel model){
        var data = new DB_CAR();
        data.setNAME(model.getName());
        data.setNAME_EN(model.getEnglishName());
        data.setSTATUS(model.getStatus());
        data.setCREATED_BY(GlobalHelper.Str.ADMIN);
        data.setCREATED_DATE(new Date());
        data.setDB_CODE(GlobalHelper.Str.GlobalDatabase);
        return data;
    }
    public  static CarDto MaptoDto(DB_CAR model,int recordCount){
        var data = new CarDto();
        data.setId(model.getID());
        data.setName(model.getNAME());
        data.setStatus(model.getSTATUS());
        data.setEnglishName(model.getNAME_EN());
        data.setCreatedBy(model.getCREATED_BY());
        data.setCreatedDate(model.getCREATED_DATE());
        data.setRecordCount(recordCount);
        data.setDatabase(model.getDB_CODE());
        data.setUpdatedBy(model.getUPDATED_BY());
        data.setUpdatedDate(model.getUPDATED_DATE());
        return data;
    }
}
