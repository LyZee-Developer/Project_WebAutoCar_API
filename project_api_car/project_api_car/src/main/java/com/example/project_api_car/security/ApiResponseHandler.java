package com.example.project_api_car.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseHandler {
    private Boolean Status = false;
    private String Message ="";
    private Object Detail="";
    private Boolean IsSuccess=false;
    public  ApiResponseHandler SetDetail(Object detail){
        this.Detail = detail;
        return this;
    }

    public  ApiResponseHandler SetSuccess(String message){
        this.Status = true;
        this.IsSuccess = true;
          this.Message = (message == null) ? "Processing Success" : message;
        return this;
    }
}
