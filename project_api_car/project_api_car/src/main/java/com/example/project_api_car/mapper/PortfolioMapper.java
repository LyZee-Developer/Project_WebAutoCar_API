package com.example.project_api_car.mapper;


import java.util.Date;
import java.util.List;

import com.example.project_api_car.data_model.portfolio.PortfolioDataModel;
import com.example.project_api_car.dto.ImageDto;
import com.example.project_api_car.dto.PortfolioDto;
import com.example.project_api_car.entity.DB_PORTFOLIO;
import com.example.project_api_car.helper.GlobalHelper;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public class PortfolioMapper {
    public  static DB_PORTFOLIO MaptoEntity(PortfolioDataModel model){
        var data = new DB_PORTFOLIO();
        data.setCreatedBy(GlobalHelper.Str.ADMIN);
        data.setCreatedDate(new Date());
        data.setDbCode(GlobalHelper.Str.GlobalDatabase);
        return data;
    }
    public  static PortfolioDto MaptoDto(DB_PORTFOLIO model,int recordCount,List<ImageDto> Image){
        var data = new PortfolioDto();
        data.setId(model.getId());
        data.setImages(Image);
        data.setRecordCount(recordCount);
        data.setDatabase(model.getDbCode());
        data.setUpdatedBy(model.getUpdatedBy());
        data.setUpdatedDate(model.getUpdatedDate());
        return data;
    }
}
