package com.example.project_api_car.mapper;


import java.util.Date;

import com.example.project_api_car.data_model.service_type.ServiceTypeDataModel;
import com.example.project_api_car.dto.ServiceTypeDto;
import com.example.project_api_car.entity.DB_SERVICE_TYPE;
import com.example.project_api_car.helper.GlobalHelper;

public class ServiceTypeMapper {
    public  static DB_SERVICE_TYPE MaptoEntity(ServiceTypeDataModel model){
        var data = new DB_SERVICE_TYPE();
        data.setNAME(model.getName());
        data.setNAME_EN(model.getEnglishName());
        data.setSTATUS(model.getStatus());
        data.setCREATED_BY(GlobalHelper.Str.ADMIN);
        data.setCREATED_DATE(new Date());
        data.setDB_CODE(GlobalHelper.Str.GlobalDatabase);
        return data;
    }
    public  static ServiceTypeDto MaptoDto(DB_SERVICE_TYPE model,int recordCount){
        var data = new ServiceTypeDto();
        data.setId(model.getID());
        data.setName(model.getNAME());
        data.setStatus(model.getSTATUS());
        data.setEnglishName(model.getNAME_EN());
        data.setCreatedBy(model.getCREATED_BY());
        data.setRecordCount(recordCount);
        data.setCreatedDate(model.getCREATED_DATE());
        data.setDatabase(model.getDB_CODE());
        data.setUpdatedBy(model.getUPDATED_BY());
        data.setUpdatedDate(model.getUPDATED_DATE());
        return data;
    }
}
