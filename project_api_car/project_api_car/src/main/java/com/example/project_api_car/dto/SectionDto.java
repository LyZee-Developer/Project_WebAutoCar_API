package com.example.project_api_car.dto;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class SectionDto {
    public Long  Id;
    private String Name;
    private String EnglishName;
    private String CreatedBy;
    private Date CreatedDate;
    private String Database;
    private String UpdatedBy;
    private Date UpdatedDate;
}
