package com.example.project_api_car.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UploadDto {
    private String Filename;
    private String PathFolder;
    private Long Size;
    private String Type;
    private String PathFilename;
    private String HostName;
}
