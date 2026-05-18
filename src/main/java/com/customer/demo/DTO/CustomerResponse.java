package com.customer.demo.DTO;

import com.customer.demo.models.Customer;

public class CustomerResponse {

    private long id;
    private  String fullName;
    private String email;
    private String phoneNo;

    public static CustomerResponse from(Customer customer) {
        CustomerResponse customerResponse = new CustomerResponse();

        customerResponse.id = customer.getId();
        customerResponse.fullName = customer.getFirstName()+ " " + customer.getLastName();
        customerResponse.email = customer.getEmail();
        customerResponse.phoneNo = customer.getPhoneNo();

        return customerResponse;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
