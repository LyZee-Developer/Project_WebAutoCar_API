package com.example.project_api_car.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.car.CarDataModel;
import com.example.project_api_car.data_model.car.CarFilterDataModel;
import com.example.project_api_car.dto.CarDto;

@Service
public interface CarService {
    List<CarDto> List(CarFilterDataModel filter);
    CarDto Create(CarDataModel model);
    CarDto Update(CarDataModel model);
    Boolean Delete(Long Id);
}
