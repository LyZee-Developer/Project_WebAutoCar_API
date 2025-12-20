package com.example.project_api_car.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ImageDto {
    private Long  id;
    private Long refId;
    private String type;
    private String pathImage;
    private String typeImage;
    private String hostUrl;
    private Long size;
    private String name;
}
