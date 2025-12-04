package com.example.project_api_car.helper;


import com.example.project_api_car.security.ApiResponseHandler;

public class SectionHelper {
    public static class URL {
        public final static String List="api/section/list";
        public final static String Create="api/section/create";
        public final static String Update="api/section/update";
        public final static String Delete="api/section/delete";
    }
    public static class Message{
        public static final ApiResponseHandler NotFound = new ApiResponseHandler().SetDetail("Section not found!");
    }
}
