package com.customer.demo.controller;

import com.customer.demo.DTO.CreateCustomerRequest;
import com.customer.demo.DTO.CustomerResponse;
import com.customer.demo.models.Customer;
import com.customer.demo.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @RestController is a combination of @Controller and @ResponseBody
 */

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomer() {

        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerResponse getCustomerbyId(@PathVariable long id){

        Optional<Customer> customer = customerService.getCustomerById(id);
//        return customer.map(cust -> CustomerResponse.from(cust)).orElse(null) ;
        return customer.map(CustomerResponse::from).orElse(null) ;


    }



    @PostMapping
    public CustomerResponse createCustomer(
            @Valid @RequestBody CreateCustomerRequest request) {
        Customer cust = customerService.createCustomer(request);
        return CustomerResponse.from(cust);
    }
}
