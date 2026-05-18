package com.customer.demo.controller;

import com.customer.demo.models.Customer;
import com.customer.demo.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @RestController is a combination of @Controller and @ResponseBody
 */

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public List<Customer> getAllCustomer() {

        return customerService.getAllCustomers();
    }
}
