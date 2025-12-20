package com.example.project_api_car.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UploadDto {
    private String filename;
    private Long size;
    private String type;
    private String pathFilename;
    private String hostName;
}
