package com.metateam.sba.controller;

import com.metateam.sba.dto.GlobalApiResponse;

public class BaseClass {
    public GlobalApiResponse successResponse(String message, Object object) {
        GlobalApiResponse response = new GlobalApiResponse();
        response.setStatus(true);
        response.setData(object);
        response.setMessage(message);
        return response;
    }

    public GlobalApiResponse failureResponse(String message, Object object) {
        //builder pattern
        return GlobalApiResponse.builder()
                .status(false)
                .data(object)
                .message(message)
                .build();
    }
}
