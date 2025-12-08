package com.example.project_api_car.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ImageDto {
    private Long  Id;
    private Long RefId;
    private String Type;
    private String PathImage;
    private String TypeImage;
    private String Size;
    private String Name;
}
