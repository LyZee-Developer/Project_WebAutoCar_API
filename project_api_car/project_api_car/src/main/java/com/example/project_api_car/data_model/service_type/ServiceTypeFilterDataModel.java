package com.example.project_api_car.data_model.service_type;

import com.example.project_api_car.data_model.IBaseFilterDataModel;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class ServiceTypeFilterDataModel extends IBaseFilterDataModel  {
    private Boolean status;
}
