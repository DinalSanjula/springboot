package com.customer.demo.controller;

import com.customer.demo.DTO.CreateCustomerRequest;
import com.customer.demo.models.Customer;
import com.customer.demo.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ViewController {
    private CustomerService customerService;

    @Autowired
    public ViewController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/customer-view")
    public String getHelloHtml(Model model){
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers",customers);

        return "index";
    }

    @GetMapping("/create-view")
    public String createUser(Model model){
        model.addAttribute("customerRequest",new CreateCustomerRequest());

        return "create";
    }

    @PostMapping("/create")
    public String createCustomer(
            @Valid @ModelAttribute("customerRequest") CreateCustomerRequest request,
            BindingResult bindingResult
    ){
        if(bindingResult.hasErrors()){
            return "create";
        }

        customerService.createCustomer(request);

        return "redirect:/index";
    }
}
