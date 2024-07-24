package com.metateam.sba.controller.customer;

import com.metateam.sba.controller.BaseClass;
import com.metateam.sba.dto.GlobalApiResponse;
import com.metateam.sba.dto.customer.CustomerDto;
import com.metateam.sba.enums.IdType;
import com.metateam.sba.service.customer.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/findAll")
    public ResponseEntity<GlobalApiResponse> finaAll(){
        List<CustomerDto> customerDtoList = customerService.findAll();
        if(customerDtoList != null){
            return new ResponseEntity<>(
                    successResponse("Data fetched successfully", customerDtoList),
                    HttpStatus.OK);
        }else{
            return new ResponseEntity<>(
                    failureResponse("Data fetch failed", null),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<GlobalApiResponse> findById(@PathVariable Integer id){
        CustomerDto customerDto = customerService.findById(id);
        if(customerDto != null){
            return new ResponseEntity<>(successResponse("Data fetched successfully",customerDto),HttpStatus.OK);
        } else{
            return new ResponseEntity<>(failureResponse("Data fetch failed",null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/findByIdType")
    public ResponseEntity<GlobalApiResponse> findByIdType(@RequestParam(value= "idType", required = false) IdType idType){
        List<CustomerDto> customerDtoList = customerService.findCustomerWithIdType(idType);
        if(customerDtoList != null){
            return new ResponseEntity<>(successResponse("Data fetched successfully",customerDtoList),HttpStatus.OK);
        } else{
            return new ResponseEntity<>(failureResponse("Data fetch failed",null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/findActiveOrInactive")
    public ResponseEntity<GlobalApiResponse> findActiveOrInactive(@RequestParam boolean isActive){
        List<CustomerDto> customerDtos = customerService.findActiveAndInactiveCustomer(isActive);
        if(customerDtos != null){
            return new ResponseEntity<>(successResponse("Data fetched successfully", customerDtos),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(failureResponse("Data fetch failed", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
