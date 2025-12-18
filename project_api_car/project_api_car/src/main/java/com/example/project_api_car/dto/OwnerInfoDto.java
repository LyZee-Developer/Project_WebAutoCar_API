package com.example.project_api_car.dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class OwnerInfoDto extends IBaseDto{
    private Long Id;
    private String Name;
    private String EnglishName;
    private String Phone;
    private String Phone1;
    private String Email;
    private String Description;
    private String SubDescription;
    private String SubDescriptionEnglish;
    private String DescriptionEnglish;
    private String FaceboolURL;
    private String InURL;
    private String InstagramURL;
    private String YoutubeURL;
    private String TelegramURL;
    private String WorkingInfo;
    private String PathImage;
}
