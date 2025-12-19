package com.example.project_api_car.mapper;


import java.util.Date;

import com.example.project_api_car.data_model.booking_appointment.BookingAppointmentDataModel;
import com.example.project_api_car.dto.BookingAppointmentDto;
import com.example.project_api_car.dto.BookingAppointmentListDto;
import com.example.project_api_car.entity.DB_BOOKING_APPOINTMENT;
import com.example.project_api_car.helper.GlobalHelper;

public class BookingAppointmentMapper {
    public  static DB_BOOKING_APPOINTMENT MaptoEntity(BookingAppointmentDataModel model){
        var data = new DB_BOOKING_APPOINTMENT();
        data.setFULL_NAME(model.getFullName());
        data.setEMAIL(model.getEmail());
        data.setPHONE(model.getPhone());
        data.setPROBLEM(model.getProblem());
        data.setSERVICE_ID(model.getServiceId());
        data.setIS_COMPLETE(false);
        data.setYEAR(model.getYear());
        data.setCAR_ID(model.getCarId());
        data.setCREATED_BY(GlobalHelper.Str.ADMIN);
        data.setCREATED_DATE(new Date());
        data.setDB_CODE(GlobalHelper.Str.GlobalDatabase);
        return data;
    }
    public  static BookingAppointmentDto MaptoDto(DB_BOOKING_APPOINTMENT model,int recordCount){
        var data = new BookingAppointmentDto();
        data.setId(model.getID());
        data.setFullname(model.getFULL_NAME());
        data.setEmail(model.getEMAIL());
        data.setCarId(model.getCAR_ID());
        data.setPhone(model.getPHONE());
        data.setYears(model.getYEAR());
        data.setServiceId(model.getSERVICE_ID());
        data.setIsComplete(model.getIS_COMPLETE());
        data.setProblem(model.getPROBLEM());
        // data.setRecordCount(recordCount);
        data.setCreatedBy(model.getCREATED_BY());
        data.setCreatedDate(model.getCREATED_DATE());
        data.setUpdatedBy(model.getUPDATED_BY());
        data.setUpdatedDate(model.getUPDATED_DATE());
        return data;
    }
    public  static BookingAppointmentDto MaptoList(BookingAppointmentListDto model,int recordCount){
        var data = new BookingAppointmentDto();
        data.setId(model.getId());
        data.setFullname(model.getFullname());
        data.setEmail(model.getEmail());
        data.setCarId(model.getCarId());
        data.setPhone(model.getPhone());
        data.setYears(model.getYears());
        data.setCarEnglishName(model.getCarEnglishName());
        data.setCarName(model.getCarName());
        data.setServiceId(model.getServiceId());
        data.setServiceEnglishName(model.getServiceEnglishName());
        data.setServiceName(model.getServiceName());
        data.setIsComplete(model.getIsComplete());
        data.setProblem(model.getProblem());
        data.setRecordCount(recordCount);
        data.setCreatedBy(model.getCreatedBy());
        data.setCreatedDate(model.getCreatedDate());
        data.setUpdatedBy(model.getUpdatedBy());
        data.setUpdatedDate(model.getUpdatedDate());
        return data;
    }
}
