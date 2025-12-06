package com.example.project_api_car.mapper;


import java.util.Date;

import com.example.project_api_car.data_model.user.UserDataModel;
import com.example.project_api_car.dto.OwnerInfoDto;
import com.example.project_api_car.entity.DB_OWNER_INFO;
import com.example.project_api_car.entity.DB_USER;

public class OwnerInfoMapper {
    public  static DB_OWNER_INFO MaptoEntity(UserDataModel model){
        var data = new DB_OWNER_INFO();
        data.setNAME(model.getName());
        data.setNAME_EN(model.getEnglishName());
        data.setEMAIL(model.getEmail());
        data.setPHONE(model.getPhone());
        data.setPHONE1(model.getPhone1());
        data.setCREATED_BY(model.getUsername());
        data.setCREATED_DATE(new Date());
        data.setDB_CODE(model.getDatabase());
        return data;
    }
    public  static OwnerInfoDto MaptoDto(DB_USER model,int recordCount){
        var data = new OwnerInfoDto();
        data.setId(model.getID());
        data.setName(model.getNAME());
        data.setEnglishName(model.getNAME_EN());
        data.setCreatedBy(model.getCREATED_BY());
        data.setCreatedDate(model.getCREATED_DATE());
        data.setDatabase(model.getDB_CODE());
        data.setUpdatedBy(model.getUPDATED_BY());
        data.setUpdatedDate(model.getUPDATED_DATE());
        return data;
    }
}
