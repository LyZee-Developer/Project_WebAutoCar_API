package com.example.project_api_car.controller;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.section.SectionDataModel;
import com.example.project_api_car.data_model.section.SectionFilterDataModel;
import com.example.project_api_car.helper.SectionHelper;
import com.example.project_api_car.implement_service.SectionImplement;
import com.example.project_api_car.repository.SectionRepository;
import com.example.project_api_car.security.ApiResponseHandler;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public  class SectionController {
    private final SectionImplement sectionImplements;
    private final SectionRepository sectionRepository;
    public  ResponseEntity<?> TestController(){
        try {
            return ResponseEntity.ok("Show me your body");
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    public  ResponseEntity<?> List(SectionFilterDataModel filter){
        try {
            var result = sectionImplements.List(filter);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public  ResponseEntity<?> Create(SectionDataModel model){
        try {
            var result = sectionImplements.Create(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
    public  ResponseEntity<?> Update(SectionDataModel model){
        try {
            if(Objects.isNull(model.getId()) || model.getId() <1) {
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Id is required!"),HttpStatus.BAD_REQUEST);
            }
            var isExisted = sectionRepository.findById(model.getId());
            if(!isExisted.isPresent()) return new ApiResponseHandler().SetDetail(SectionHelper.Message.NotFound,HttpStatus.BAD_REQUEST);
             var result = sectionImplements.Update(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     public  ResponseEntity<?> Delete(Long Id){
        if(Id < 1 ) return new ApiResponseHandler().SetDetail("Id is required!",HttpStatus.BAD_REQUEST);
        var isExisted = sectionRepository.findById(Id);
        if(!isExisted.isPresent()){
            return new ApiResponseHandler().SetDetail(SectionHelper.Message.NotFound,HttpStatus.BAD_REQUEST);
        }
        var result = sectionImplements.Delete(Id);
        return ResponseEntity.ok(result);
    }
}
