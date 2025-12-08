package com.example.project_api_car.mapper;


import com.example.project_api_car.data_model.upload.UploadDataModel;
import com.example.project_api_car.dto.ImageDto;
import com.example.project_api_car.entity.DB_IMAGE;

public class ImageMapper {
    public  static DB_IMAGE MaptoEntity(UploadDataModel model){
        var data = new DB_IMAGE();
        data.setHOST_IMG(model.getHostImage());
        data.setPATH_IMG(model.getPathImage());
        data.setSIZE_IMG(model.getSize());
        data.setTYPE(model.getType());
        data.setTYPE_IMG(model.getTypeImage());
        return data;
    }
    public  static ImageDto MaptoDto(DB_IMAGE model,int recordCount){
        var data = new ImageDto();
        data.setId(model.getID());
        return data;
    }
}
