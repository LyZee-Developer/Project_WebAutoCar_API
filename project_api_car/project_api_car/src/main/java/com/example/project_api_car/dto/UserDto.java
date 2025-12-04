package com.example.project_api_car.dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserDto extends IBaseDto {
    public Long  Id;
    private String Name;
    private String EnglishName;
    private String Email;
    private String Phone;
    private String Code;
    private String Phone1;
    private Boolean Gender;
}
