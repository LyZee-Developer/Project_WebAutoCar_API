package com.example.project_api_car.controller;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.car.CarDataModel;
import com.example.project_api_car.data_model.car.CarFilterDataModel;
import com.example.project_api_car.helper.CarHelper;
import com.example.project_api_car.implement_service.CarImplement;
import com.example.project_api_car.repository.ServiceTypeRepository;
import com.example.project_api_car.security.ApiResponseHandler;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public  class CarController {
    private final CarImplement carImplement;
    private final ServiceTypeRepository serviceTypeRepository;
    
    public  ResponseEntity<?> List(CarFilterDataModel filter){
        try {
            var result = carImplement.List(filter);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public  ResponseEntity<?> Create(CarDataModel model){
        try {
            var result = carImplement.Create(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
               return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    public  ResponseEntity<?> Update(CarDataModel model){
        try {
            if(Objects.isNull(model.getId()) || model.getId() <1) {
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Id is required!"),HttpStatus.BAD_REQUEST);
            }
            var isExisted = serviceTypeRepository.findById(model.getId());
            if(!isExisted.isPresent()) return  new ApiResponseHandler().SetDetail(CarHelper.Message.NotFound,HttpStatus.BAD_REQUEST);
             var result = carImplement.Update(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     public  ResponseEntity<?> Delete(Long Id){
        if(Id < 1 ) return new ApiResponseHandler().SetDetail("Id is required!",HttpStatus.BAD_REQUEST);
        var isExisted = serviceTypeRepository.findById(Id);
        if(!isExisted.isPresent()){
            return new ApiResponseHandler().SetDetail(CarHelper.Message.NotFound,HttpStatus.BAD_REQUEST);
        }
        var result = carImplement.Delete(Id);
        return ResponseEntity.ok(result);
    }

    
}
