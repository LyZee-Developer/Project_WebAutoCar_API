package com.example.project_api_car.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.owner_info.OwnerInfoDataModel;
import com.example.project_api_car.data_model.owner_info.OwnerInfoFilterDataModel;
import com.example.project_api_car.dto.OwnerInfoDto;

@Service
public interface OwnerInfoService {
    List<OwnerInfoDto> List(OwnerInfoFilterDataModel filter);
    OwnerInfoDto Create(OwnerInfoDataModel model);
    OwnerInfoDto Update(OwnerInfoDataModel model);
    Boolean Delete(Long Id);
    Boolean IsExistedCar(Long CarId);
}
