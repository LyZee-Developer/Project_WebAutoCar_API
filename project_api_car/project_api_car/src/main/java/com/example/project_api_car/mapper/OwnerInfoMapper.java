package com.example.project_api_car.mapper;


import java.util.Date;

import com.example.project_api_car.data_model.owner_info.OwnerInfoDataModel;
import com.example.project_api_car.dto.OwnerInfoDto;
import com.example.project_api_car.entity.DB_OWNER_INFO;
import com.example.project_api_car.helper.GlobalHelper;

public class OwnerInfoMapper {
    public  static DB_OWNER_INFO MaptoEntity(OwnerInfoDataModel model){
        var data = new DB_OWNER_INFO();
        data.setNAME(model.getName());
        data.setNAME_EN(model.getEnglishName());
        data.setEMAIL(model.getEmail());
        data.setPHONE(model.getPhone());
        data.setPHONE1(model.getPhone1());
        data.setDESCRIPTION(model.getDescription());
        data.setDESCRIPTION_EN(model.getDescriptionEnglish());
        data.setSUB_DESCRIPTION_EN(model.getSubDescriptionEnglish());
        data.setSUB_DESCRIPTION(model.getSubDescription());
        data.setFACEBOOK_URL(model.getFacebookURL());
        data.setIN_URL(model.getInURL());
        data.setINSTAGRAM_URL(model.getInstagramURL());
        data.setTELEGRAM_URL(model.getTelegramURL());
        data.setYOUTUBE_URL(model.getYoutubeURL());
        data.setWORKING_INFO(model.getWorkingInfo());
        data.setCREATED_BY(GlobalHelper.Str.ADMIN);
        data.setCREATED_DATE(new Date());
        data.setDB_CODE(GlobalHelper.Str.GlobalDatabase);
        return data;
    }
    public  static OwnerInfoDto MaptoDto(DB_OWNER_INFO model,int recordCount,String pathImage){
        var data = new OwnerInfoDto();
        data.setId(model.getID());
        data.setName(model.getNAME());
        data.setEnglishName(model.getNAME_EN());
        data.setCreatedBy(model.getCREATED_BY());
        data.setEmail(model.getEMAIL());
        data.setPhone(model.getPHONE());
        data.setPhone1(model.getPHONE1());
        data.setFaceboolURL(model.getFACEBOOK_URL());
        data.setDescription(model.getDESCRIPTION());
        data.setDescriptionEnglish(model.getDESCRIPTION_EN());
        data.setSubDescription(model.getSUB_DESCRIPTION());
        data.setSubDescriptionEnglish(model.getSUB_DESCRIPTION_EN());
        data.setInstagramURL(model.getINSTAGRAM_URL());
        data.setPathImage(pathImage);
        data.setInURL(model.getIN_URL());
        data.setWorkingInfo(model.getWORKING_INFO());
        data.setTelegramURL(model.getTELEGRAM_URL());
        data.setYoutubeURL(model.getYOUTUBE_URL());
        data.setRecordCount(recordCount);
        data.setCreatedDate(model.getCREATED_DATE());
        data.setDatabase(model.getDB_CODE());
        data.setUpdatedBy(model.getUPDATED_BY());
        data.setUpdatedDate(model.getUPDATED_DATE());
        return data;
    }
}
