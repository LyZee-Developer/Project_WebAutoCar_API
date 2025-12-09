package com.example.project_api_car.data_model.block_content_detail;

import com.example.project_api_car.data_model.IBaseDataModel;
import com.example.project_api_car.data_model.upload.UploadDataModel;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlockContentDetailDataModel extends  IBaseDataModel{
    private Long Id;
    @Size(max = 255, message = "Name cannot exceed 255 characters")
    private String Title;
    private Long BlockContentId;
    private String TitleEnglish;
    private String Description;
    private String SubTitle;
    private String SubTitleEnglish;
    private String DescriptionEnglish;
    private Boolean Status;
    private UploadDataModel upload;
}
