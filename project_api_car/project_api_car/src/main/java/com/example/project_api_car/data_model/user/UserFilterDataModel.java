package com.example.project_api_car.data_model.user;

import com.example.project_api_car.data_model.IBaseFilterDataModel;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class UserFilterDataModel extends IBaseFilterDataModel  {
    private Boolean status;
}
