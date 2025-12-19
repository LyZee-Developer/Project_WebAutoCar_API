package com.example.project_api_car.data_model.block_content_detail;

import com.example.project_api_car.data_model.IBaseDataModel;
import com.example.project_api_car.data_model.upload.UploadDataModel;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlockContentDetailDataModel extends  IBaseDataModel{
    private Long id;
    @Size(max = 255, message = "Name cannot exceed 255 characters")
    private String title;
    private Long blockContentId;
    private String titleEnglish;
    private String description;
    private String subTitle;
    private String subTitleEnglish;
    private String descriptionEnglish;
    private Boolean status;
    private UploadDataModel upload;
}
