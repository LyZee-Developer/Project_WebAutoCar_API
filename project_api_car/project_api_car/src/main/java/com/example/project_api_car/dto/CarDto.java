package com.example.project_api_car.dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CarDto extends IBaseDto{
    public Long  Id;
    private String Name;
    private String EnglishName;
    private Boolean Status;
}
