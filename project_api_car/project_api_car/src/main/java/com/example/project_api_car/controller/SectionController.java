package com.example.project_api_car.controller;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.section.SectionDataModel;
import com.example.project_api_car.implement_service.SectionImplement;
import com.example.project_api_car.repository.SectionRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public  class SectionController {
    private SectionImplement sectionImplements;
    private SectionRepository sectionRepository;
    public  ResponseEntity<?> TestController(){
        try {
            return ResponseEntity.ok("Show me your body");
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
            if(Objects.isNull(model.getId()) || model.getId() <1) return  ResponseEntity.ok("The field id is required!");
            var isExisted = sectionRepository.findById(model.getId());
            if(!isExisted.isPresent()) return new ResponseEntity<>("Section not found!",HttpStatus.BAD_REQUEST);
             var result = sectionImplements.Update(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     public  ResponseEntity<?> Delete(Long Id){
        if(Id < 1 ) return new ResponseEntity<>("Id is required!",HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok("Show me your body");
    }
}
