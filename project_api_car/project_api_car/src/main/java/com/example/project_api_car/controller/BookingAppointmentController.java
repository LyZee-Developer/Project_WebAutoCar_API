package com.example.project_api_car.controller;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.booking_appointment.BookingAppointmentDataModel;
import com.example.project_api_car.data_model.booking_appointment.BookingAppointmentFilterDataModel;
import com.example.project_api_car.helper.BookingAppointmentHelper;
import com.example.project_api_car.helper.UserHelper;
import com.example.project_api_car.implement_service.BookingAppointmentImplement;
import com.example.project_api_car.implement_service.CarImplement;
import com.example.project_api_car.implement_service.ServiceTypeImplement;
import com.example.project_api_car.repository.BookingAppointmentRepository;
import com.example.project_api_car.security.ApiResponseHandler;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BookingAppointmentController {
    private final BookingAppointmentImplement bookingAppointmentImplement;
    private final BookingAppointmentRepository bookingAppointmentRepository;
    private final CarImplement carImplement;
    private final ServiceTypeImplement serviceTypeImplement;

    public ResponseEntity<?> List(BookingAppointmentFilterDataModel filter) {
        try {
            var result = bookingAppointmentImplement.List(filter);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> Create(BookingAppointmentDataModel model) {
        try {
            String[] splitServiceId = model.getServiceId().split(",");
            for (String service : splitServiceId) {
                if(!serviceTypeImplement.IsExistService(Long.parseLong(service))) {
                    return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Service was not found!"),
                        HttpStatus.BAD_REQUEST);
                } 
            }
           
            if(!carImplement.IsExistedCar(model.getCarId())) {
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Car was not found!"),
                    HttpStatus.BAD_REQUEST);
            } 
            var result = bookingAppointmentImplement.Create(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> Update(BookingAppointmentDataModel model) {
        try {
            if (Objects.isNull(model.getId()) || model.getId() < 1) {
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Id is required!"),
                        HttpStatus.BAD_REQUEST);
            }
            String[] splitServiceId = model.getServiceId().split(",");
            for (String service : splitServiceId) {
                if(!serviceTypeImplement.IsExistService(Long.parseLong(service))) {
                    return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Service was not found!"),
                        HttpStatus.BAD_REQUEST);
                } 
            }
            if(!carImplement.IsExistedCar(model.getCarId())) {
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Car was not found!"),
                    HttpStatus.BAD_REQUEST);
            } 
            var isExisted = bookingAppointmentRepository.findById(model.getId());
            if (!isExisted.isPresent()){
                return new ApiResponseHandler().SetDetail(UserHelper.Message.NotFound, HttpStatus.NOT_FOUND);
            }
            var result = bookingAppointmentImplement.Update(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> Delete(Long Id) {
        if (Id < 1)
            return new ApiResponseHandler().SetDetail("Id is required!", HttpStatus.BAD_REQUEST);
        var isExisted = bookingAppointmentRepository.findById(Id);
        if (!isExisted.isPresent()) {
            return new ApiResponseHandler().SetDetail(BookingAppointmentHelper.Message.NotFound, HttpStatus.NOT_FOUND);
        }
        var result = bookingAppointmentImplement.Delete(Id);
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<?> ChangeStatus(Long id,Boolean status) {
        var isExisted = bookingAppointmentRepository.findById(id);
        if (!isExisted.isPresent()) {
            return new ApiResponseHandler().SetDetail(BookingAppointmentHelper.Message.NotFound, HttpStatus.NOT_FOUND);
        }
        if(isExisted.get().getIS_COMPLETE().booleanValue()==status){
             return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Current your status have change already!"),HttpStatus.BAD_REQUEST); 
        }
        var result = bookingAppointmentImplement.ChangeStatus(id,status);
        return ResponseEntity.ok(new ApiResponseHandler().SetSuccess(result));
    }

}
