package com.example.project_api_car.mapper;


import java.util.Date;

import com.example.project_api_car.data_model.user.UserDataModel;
import com.example.project_api_car.dto.UserDto;
import com.example.project_api_car.entity.DB_USER;

public class UserMapper {
    public  static DB_USER MaptoEntity(UserDataModel model){
        var data = new DB_USER();
        data.setName(model.getName());
        data.setNameEn(model.getEnglishName());
        data.setEmail(model.getEmail());
        data.setPhone(model.getPhone());
        data.setPhone1(model.getPhone1());
        data.setGender(model.getGender());
        data.setStatus(model.getStatus());
        data.setUserCode(model.getUserCode());
        data.setCreatedBy(model.getUsername());
        data.setCreatedDate(new Date());
        data.setDbCode(model.getDatabase());
        return data;
    }
    public  static UserDto MaptoDto(DB_USER model,int recordCount,String PathImage){
        var data = new UserDto();
        data.setId(model.getId());
        data.setName(model.getName());
        data.setEnglishName(model.getNameEn());
        data.setPhone(model.getPhone());
        data.setPhone1(model.getPhone1());
        data.setStatus(model.getStatus());
        data.setEmail(model.getEmail());
        data.setGender(model.getGender());
        data.setCode(model.getUserCode());
        data.setPathImage(PathImage);
        data.setRecordCount(recordCount);
        data.setCreatedBy(model.getCreatedBy());
        data.setCreatedDate(model.getCreatedDate());
        data.setDatabase(model.getDbCode());
        data.setUpdatedBy(model.getUpdatedBy());
        data.setUpdatedDate(model.getUpdatedDate());
        return data;
    }
}
