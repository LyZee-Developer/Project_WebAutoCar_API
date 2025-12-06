package com.example.project_api_car.dto;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingAppointmentDto {
    private Long Id;
    private String Fullname;
    private String Email;
    private String  Phone;
    private Long ServiceId;
    private String ServiceName;
    private String ServiceEnglishName;
    private String  Problem;
    private Long CarId;
    private String  CarName;
    private String  CarEnglishName;
    private String  Years;
    private int  RecordCount;
    private Boolean  IsComplete;
    private String  CreatedBy;
    private String  UpdatedBy;
    private Date  CreatedDate;
    private Date  UpdatedDate;

    // private Long Id;
    // private String Fullname;
    // private String Email;
    // private String Phone;
    // private Long ServiceId;
    // private String ServiceName;
    // private String ServiceEnglishName;
    // private String Problem;
    // private Long CarId;
    // private String CarName;
    // private String CarEnglishName;
    // private String Years;
    // private Boolean IsComplete;
    // private String CreatedBy;
    // private String UpdatedBy;
    // private Date CreatedDate;
    // private Date UpdatedDate;
}

