package com.example.project_api_car.data_model.portfolio;

import com.example.project_api_car.data_model.IBaseFilterDataModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PortfolioFilterDataModel extends  IBaseFilterDataModel{
    private Boolean status;
}
