package com.example.project_api_car.dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CarDto extends IBaseDto{
    public Long  id;
    private String name;
    private String englishName;
    private String pathImage;
    private Boolean status;
}
