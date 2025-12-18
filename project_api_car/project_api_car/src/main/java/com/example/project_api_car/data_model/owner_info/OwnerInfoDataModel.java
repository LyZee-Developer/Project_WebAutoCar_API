package com.example.project_api_car.data_model.owner_info;

import com.example.project_api_car.data_model.IBaseDataModel;
import com.example.project_api_car.data_model.upload.UploadDataModel;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OwnerInfoDataModel extends  IBaseDataModel{
    public Long Id;
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    public String Name;
    @Size(max = 50, message = "EnglishName cannot exceed 50 characters")
    public String EnglishName;
    @Size(max = 15, message = "Phone cannot exceed 15 characters")
    private String Phone;
    @Size(max = 15, message = "Phone1 cannot exceed 15 characters")
    private String Phone1;
    private String Email;
    private String SubDescription;
    private String SubDescriptionEnglish;
    private String Description;
    private String DescriptionEnglish;
    private String FacebookURL;
    private String InstagramURL;
    private String InURL;
    private String YoutubeURL;
    private String TelegramURL;
    @Size(max = 255, message = "WorkingInfo cannot exceed 255 characters")
    private String WorkingInfo;
    private UploadDataModel upload;
}
