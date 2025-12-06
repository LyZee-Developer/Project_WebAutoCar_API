package com.example.project_api_car.dto;
import java.time.LocalDateTime;
import java.util.Date;

public interface BookingAppointmentListDto {
    Long getId();
    String getFullname();
    String getEmail();
    String getPhone();
    Long getServiceId();
    String getServiceName();
    String getServiceEnglishName();
    String getProblem();
    Long getCarId();
    String getCarName();
    String getCarEnglishName();
    String getYears();
    Boolean getIsComplete();
    String getCreatedBy();
    String getUpdatedBy();
    Date getCreatedDate();
    Date getUpdatedDate();
}

