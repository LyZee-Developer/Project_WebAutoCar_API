package com.example.project_api_car.helper;


import com.example.project_api_car.security.ApiResponseHandler;

public class CarHelper {
    public static class URL {
        public final static String List="api/car/list";
        public final static String Create="api/car/create";
        public final static String Update="api/car/update";
        public final static String Delete="api/car/delete";
    }
    public static class Message{
        public static final ApiResponseHandler NotFound = new ApiResponseHandler().SetDetail("Car not found!");
    }
}
