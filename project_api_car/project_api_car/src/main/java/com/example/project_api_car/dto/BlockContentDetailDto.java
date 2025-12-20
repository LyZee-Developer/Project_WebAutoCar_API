package com.example.project_api_car.dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class BlockContentDetailDto extends IBaseDto{
    public Long  id;
    private String title;
    private String titleEnglish;
    private String description;
    private String descriptionEnglish;
    private String pathImage;
    private Boolean status;
}
