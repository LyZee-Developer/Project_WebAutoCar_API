package com.example.project_api_car.data_model.upload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UploadDataModel {
    private Long  Id;
    private Long RefId;
    private String Type;
    private String PathImage;
    private String TypeImage;
    private String HostImage;
    private Long Size;
    private String Name;
    private String Base64Text;
}
