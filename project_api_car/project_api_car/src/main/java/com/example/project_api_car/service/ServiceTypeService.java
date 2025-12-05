package com.example.project_api_car.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.service_type.ServiceTypeDataModel;
import com.example.project_api_car.data_model.service_type.ServiceTypeFilterDataModel;
import com.example.project_api_car.dto.ServiceTypeDto;

@Service
public interface ServiceTypeService {
    List<ServiceTypeDto> List(ServiceTypeFilterDataModel filter);
    ServiceTypeDto Create(ServiceTypeDataModel model);
    ServiceTypeDto Update(ServiceTypeDataModel model);
    Boolean Delete(Long Id);
}
