package com.example.project_api_car.mapper;


import java.util.Date;

import com.example.project_api_car.data_model.section.SectionDataModel;
import com.example.project_api_car.dto.SectionDto;
import com.example.project_api_car.entity.DB_SECTION;

public class SectionMapper {
    public  static DB_SECTION MaptoEntity(SectionDataModel model){
        var data = new DB_SECTION();
        data.setNAME(model.getName());
        data.setNAME_EN(model.getEnglishName());
        data.setCREATED_BY(model.getUsername());
        data.setCREATED_DATE(new Date());
        data.setDB_CODE(model.getDatabase());
        return data;
    }
    public  static SectionDto MaptoDto(DB_SECTION model){
        var data = new SectionDto();
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
