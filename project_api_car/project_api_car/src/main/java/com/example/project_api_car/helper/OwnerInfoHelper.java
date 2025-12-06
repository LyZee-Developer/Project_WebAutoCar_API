package com.example.project_api_car.helper;


import com.example.project_api_car.security.ApiResponseHandler;

public class OwnerInfoHelper {
    public static class URL {
        public final static String List="api/owner_info/list";
        public final static String Create="api/owner_info/create";
        public final static String Update="api/owner_info/update";
        public final static String Delete="api/owner_info/delete";
        public final static String CheckCode="api/owner_info/check_code";
    }
    public static class Message{
        public static final ApiResponseHandler NotFound = new ApiResponseHandler().SetDetail("Owner info not found!");
    }
}
