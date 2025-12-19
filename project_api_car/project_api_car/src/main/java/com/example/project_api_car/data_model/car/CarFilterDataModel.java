package com.example.project_api_car.data_model.car;

import com.example.project_api_car.data_model.IBaseFilterDataModel;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class CarFilterDataModel extends IBaseFilterDataModel  {
    private Boolean status;
}
