package com.example.project_api_car.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.portfolio.PortfolioDataModel;
import com.example.project_api_car.data_model.portfolio.PortfolioFilterDataModel;
import com.example.project_api_car.helper.CarHelper;
import com.example.project_api_car.implement_service.PortfolioImplement;
import com.example.project_api_car.repository.PortfolioRepository;
import com.example.project_api_car.security.ApiResponseHandler;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public  class PortfolioController {
    private final PortfolioImplement portfolioImplement;
    private final PortfolioRepository portfolioRepository;
    
    public  ResponseEntity<?> List(PortfolioFilterDataModel filter){
        try {
            var result = portfolioImplement.List(filter);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public  ResponseEntity<?> Create(PortfolioDataModel model){
        try {
            if(model.getUploads().isEmpty() ) return new ApiResponseHandler().SetDetail("uploads is required!",HttpStatus.BAD_REQUEST);
            var result = portfolioImplement.Create(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
               return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     public  ResponseEntity<?> Delete(Long Id){
        if(Id < 1 ) return new ApiResponseHandler().SetDetail("Id is required!",HttpStatus.BAD_REQUEST);
        var isExisted = portfolioRepository.findById(Id);
        if(!isExisted.isPresent()){
            return new ApiResponseHandler().SetDetail(CarHelper.Message.NotFound,HttpStatus.BAD_REQUEST);
        }
        var result = portfolioImplement.Delete(Id);
        return ResponseEntity.ok(result);
    }

    public  ResponseEntity<?> DeleteImage(Long Id){
        if(Id < 1 ) return new ApiResponseHandler().SetDetail("imageId is required!",HttpStatus.BAD_REQUEST);
        var result = portfolioImplement.DeleteImage(Id);
        return ResponseEntity.ok(result);
    }

    
}
