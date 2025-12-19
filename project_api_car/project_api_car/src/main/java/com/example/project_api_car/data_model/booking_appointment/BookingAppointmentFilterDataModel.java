package com.example.project_api_car.data_model.booking_appointment;

import com.example.project_api_car.data_model.IBaseFilterDataModel;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class BookingAppointmentFilterDataModel extends IBaseFilterDataModel  {
    private Boolean isComplete;
}
