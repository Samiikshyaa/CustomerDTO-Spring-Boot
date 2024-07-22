package com.metateam.sba.controller.customer;

import com.metateam.sba.controller.BaseClass;
import com.metateam.sba.dto.GlobalApiResponse;
import com.metateam.sba.dto.customer.CustomerDto;
import com.metateam.sba.service.customer.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController extends BaseClass {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @RequestMapping (value ="/create", method = RequestMethod.POST)
    public ResponseEntity<GlobalApiResponse> saveCustomer(@RequestBody CustomerDto customerdto){
//        send this to service so that the customer gets stored
        customerdto = customerService.create(customerdto);
        if(customerdto != null){
            return new ResponseEntity<>(
                    successResponse("Data saved successfully", customerdto),
                    HttpStatus.OK);
        }else{
            return new ResponseEntity<>(
                    failureResponse("Customer creation failed", null),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
