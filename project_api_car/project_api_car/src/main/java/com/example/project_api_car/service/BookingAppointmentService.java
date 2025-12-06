package com.example.project_api_car.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.booking_appointment.BookingAppointmentDataModel;
import com.example.project_api_car.data_model.booking_appointment.BookingAppointmentFilterDataModel;
import com.example.project_api_car.dto.BookingAppointmentDto;
import com.example.project_api_car.dto.BookingAppointmentListDto;

@Service
public interface BookingAppointmentService {
    List<BookingAppointmentDto> List(BookingAppointmentFilterDataModel filter);
    BookingAppointmentDto Create(BookingAppointmentDataModel model);
    BookingAppointmentDto Update(BookingAppointmentDataModel model);
    Boolean Delete(Long Id);
    String ChangeStatus(Long Id,Boolean status);
    Boolean IsExistedUserById(Long Id);
}
