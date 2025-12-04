package com.example.project_api_car.mapper;


import java.util.Date;

import com.example.project_api_car.data_model.user.UserDataModel;
import com.example.project_api_car.dto.UserDto;
import com.example.project_api_car.entity.DB_USER;

public class UserMapper {
    public  static DB_USER MaptoEntity(UserDataModel model){
        var data = new DB_USER();
        data.setNAME(model.getName());
        data.setNAME_EN(model.getEnglishName());
        data.setEMAIL(model.getEmail());
        data.setPHONE(model.getPhone());
        data.setPHONE1(model.getPhone1());
        data.setGENDER(model.getGENDER());
        data.setUSER_CODE(model.getUserCode());
        data.setCREATED_BY(model.getUsername());
        data.setCREATED_DATE(new Date());
        data.setDB_CODE(model.getDatabase());
        return data;
    }
    public  static UserDto MaptoDto(DB_USER model,Long recordCount){
        var data = new UserDto();
        data.setId(model.getID());
        data.setName(model.getNAME());
        data.setEnglishName(model.getNAME_EN());
        data.setPhone(model.getPHONE());
        data.setPhone1(model.getPHONE1());
        data.setEmail(model.getEMAIL());
        data.setGender(model.getGENDER());
        data.setCode(model.getUSER_CODE());
        data.setRecordCount(recordCount);
        data.setCreatedBy(model.getCREATED_BY());
        data.setCreatedDate(model.getCREATED_DATE());
        data.setDatabase(model.getDB_CODE());
        data.setUpdatedBy(model.getUPDATED_BY());
        data.setUpdatedDate(model.getUPDATED_DATE());
        return data;
    }
}
