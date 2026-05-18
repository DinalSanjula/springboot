package com.customer.demo.service;

import com.customer.demo.DTO.CreateCustomerRequest;
import com.customer.demo.DTO.CustomerResponse;
import com.customer.demo.models.Customer;
import com.customer.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {  // constructor injections
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(long id){
        return customerRepository.findById(id);
    }

    public Customer createCustomer(CreateCustomerRequest request) {

        if (customerRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Customer already exists with the email" + request.getEmail());
        }
        Customer customer = new Customer(request.getFirstName(),
                request.getLastName() , request.getEmail());

        customer.setPhoneNo(request.getPhoneNo());

        return customerRepository.save(customer);
    }

    public Optional<Customer> getCustomerByEmail(String email){
        return customerRepository.findByEmail(email);
    }


}
