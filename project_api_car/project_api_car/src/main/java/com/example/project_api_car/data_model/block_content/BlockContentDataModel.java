package com.example.project_api_car.data_model.block_content;

import com.example.project_api_car.data_model.IBaseDataModel;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlockContentDataModel extends  IBaseDataModel{
    private Long id;
    @Size(max = 255, message = "Name cannot exceed 255 characters")
    private String title;
    private String titleEnglish;
    private String description;
    private String subTitle;
    private String subTitleEnglish;
    private String descriptionEnglish;
    private String type;
    private Boolean status;
}
