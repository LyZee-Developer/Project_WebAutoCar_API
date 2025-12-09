package com.example.project_api_car.dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class BlockContentDetailDto extends IBaseDto{
    public Long  Id;
    private String Title;
    private String TitleEnglish;
    private String Description;
    private String DescriptionEnglish;
    private String PathImage;
    private Boolean Status;
}
