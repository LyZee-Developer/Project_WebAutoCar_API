package com.example.project_api_car.apicontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project_api_car.helper.SectionHelper;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class SectionApiController {
    @GetMapping("api/test/read")
    public ResponseEntity<?> TestController(){
        return new ResponseEntity<>("hellow orld",HttpStatus.OK);
    }
    
    @GetMapping(SectionHelper.URL.List)
    public String List(){
        return "hello world from spring boot";
    }

    @GetMapping(SectionHelper.URL.Create)
    public String Create(){
        return "hello world from spring boot";
    }

    @GetMapping(SectionHelper.URL.Update)
    public String Update(){
        return "hello world from spring boot";
    }

    @GetMapping(SectionHelper.URL.Delete)
    public String Delete(){
        return "hello world from spring boot";
    }
}
