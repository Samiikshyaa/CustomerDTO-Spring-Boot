package com.metateam.sba.controller;

import com.metateam.sba.dto.GlobalApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController //Controller + response Body
public class MainController extends BaseClass {

    @RequestMapping("/")
    public ResponseEntity<GlobalApiResponse> mainRequest() {
        String[] lists = {"Samikshya", "Utsav", "Prateek", "Suyog"};
        List<String> list = Arrays.asList(lists);
        try {
            list.get(3);
            return new ResponseEntity<>(
                    successResponse("Data fetched successfully", list),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    failureResponse("Data fetched failed", e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
