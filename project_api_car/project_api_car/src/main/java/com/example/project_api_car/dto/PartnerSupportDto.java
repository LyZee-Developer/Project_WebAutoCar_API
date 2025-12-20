package com.example.project_api_car.dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class PartnerSupportDto extends IBaseDto{
    public Long  id;
    private String name;
    private String englishName;
    private Boolean status;
    private String pathImage;
}
