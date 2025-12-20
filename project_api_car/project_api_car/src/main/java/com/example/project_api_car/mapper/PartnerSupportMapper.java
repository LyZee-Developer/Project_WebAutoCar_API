package com.example.project_api_car.mapper;


import java.util.Date;

import com.example.project_api_car.data_model.partner_support.PartnerSupportDataModel;
import com.example.project_api_car.dto.PartnerSupportDto;
import com.example.project_api_car.entity.DB_PARTNER_SUPPORT;
import com.example.project_api_car.helper.GlobalHelper;

public class PartnerSupportMapper {
    public  static DB_PARTNER_SUPPORT MaptoEntity(PartnerSupportDataModel model){
        var data = new DB_PARTNER_SUPPORT();
        data.setName(model.getName());
        data.setNameEn(model.getEnglishName());
        data.setStatus(model.getStatus());
        data.setCreatedBy(GlobalHelper.Str.ADMIN);
        data.setCreatedDate(new Date());
        data.setDbCode(GlobalHelper.Str.GlobalDatabase);
        return data;
    }
    public  static PartnerSupportDto MaptoDto(DB_PARTNER_SUPPORT model,int recordCount,String pathImage){
        var data = new PartnerSupportDto();
        data.setId(model.getId());
        data.setName(model.getName());
        data.setStatus(model.getStatus());
        data.setEnglishName(model.getNameEn());
        data.setCreatedBy(model.getCreatedBy());
        data.setCreatedDate(model.getCreatedDate());
        data.setPathImage(pathImage);
        data.setRecordCount(recordCount);
        data.setDatabase(model.getDbCode());
        data.setUpdatedBy(model.getUpdatedBy());
        data.setUpdatedDate(model.getUpdatedDate());
        return data;
    }
}
