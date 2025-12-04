package com.example.project_api_car.helper;


import com.example.project_api_car.security.ApiResponseHandler;

public class UserHelper {
    public static class URL {
        public final static String List="api/user/list";
        public final static String Create="api/user/create";
        public final static String Update="api/user/update";
        public final static String Delete="api/user/delete";
        public final static String CheckCode="api/user/check_code";
    }
    public static class Message{
        public static final ApiResponseHandler NotFound = new ApiResponseHandler().SetDetail("User not found!");
    }
}
