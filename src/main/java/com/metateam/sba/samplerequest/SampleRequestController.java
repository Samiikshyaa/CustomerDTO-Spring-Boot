package com.metateam.sba.samplerequest;

import com.metateam.sba.controller.BaseClass;
import com.metateam.sba.dto.GlobalApiResponse;
import com.metateam.sba.dto.PersonDto;
import com.metateam.sba.dto.PostDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sample")
public class SampleRequestController extends BaseClass {

    //        This is the demo for passing the json data form request
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity<GlobalApiResponse> save(@RequestBody PersonDto personDto) {
        //validate + extra logic + save
        return new ResponseEntity<>(
                successResponse("Data fetched successfully", personDto),
                HttpStatus.OK);
    }

    //        This is the demo for passing the query parameters
    @RequestMapping(value = "queryData", method = RequestMethod.GET)
    public ResponseEntity<GlobalApiResponse> sampleQueryParamExample(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "address", required = false) String address) {

        //  we can use one of these data.
        return new ResponseEntity<>(
                successResponse("Data sent successfully", null),
                HttpStatus.OK
        );
    }

    @RequestMapping(value = "formData", method = RequestMethod.POST)
    public ResponseEntity<GlobalApiResponse> sampleFormDataExample(@ModelAttribute PostDto postDto) {
        return new ResponseEntity<>(
                successResponse("Data fetch successfully", postDto),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/customer-id/{customerId}/customer-name/{customerName}", method = RequestMethod.GET)
    public ResponseEntity<GlobalApiResponse> samplePathVariableData(@PathVariable("customerId") Long id, @PathVariable("customerName")String customerName){
        return new ResponseEntity<>(
                successResponse("Data fetched successfully", null),
                HttpStatus.OK );
    }
}
